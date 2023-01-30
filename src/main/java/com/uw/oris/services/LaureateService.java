package com.uw.oris.services;

import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.uw.oris.utils.JSONUtil.getCount;
import static com.uw.oris.utils.JSONUtil.getCountryList;

/**
 * Service to make Asynchronous calls to laureates API 2.1.
 */
@Slf4j
@Component
public class LaureateService {
    private final static String API = "https://api.nobelprize.org/2.1/laureates";
    private final static int batchSize = 100;
    private static final String ACCEPT = "accept";
    private static final String APPLICATION_JSON = "application/json";
    private static final String OFFSET = "offset";
    private static final String LIMIT = "limit";

    private final AsyncHttpClient client = new DefaultAsyncHttpClient();

    /**
     * Asynchronous executor for laureate api.
     * More details can be found at https://app.swaggerhub.com/apis/NobelMedia/NobelMasterData/2.1#/default/get_laureates
     *
     * @param offset number of laureate to skip
     * @param limit  number of laureate to fetch
     * @return a completable future object
     */
    private CompletableFuture<Response> execAPI(final int offset, final int limit) {
        return client.prepareGet(API)
                .setHeader(ACCEPT, APPLICATION_JSON)
                .setQueryParams(Map.of(OFFSET, Collections.singletonList(String.valueOf(offset)),
                        LIMIT, Collections.singletonList(String.valueOf(limit))))
                .execute()
                .toCompletableFuture();
    }

    /**
     * Makes a call to fetch just one record. This is required to access the `count` from `meta` key.
     *
     * @return total number of laureates present across pagination
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public int getLaureateCount() throws ExecutionException, InterruptedException {
        log.info("Fetching count of all laureates from api");
        final CompletableFuture<Response> completableFuture = execAPI(1, 1);

        final int count = getCount(completableFuture.join().getResponseBody());
        log.info(String.format("Total number of laureates are: %s", count));
        return count;
    }

    /**
     * Get Country for all laureates. It makes asynchronous calls in batches to get all laureates and simultaneously
     * parse their country.
     *
     * @return list of country for all laureates
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public List<String> getCountryForAllLaureates() throws ExecutionException, InterruptedException {
        int count = getLaureateCount();
        List<CompletableFuture<Response>> completableFutureList = new ArrayList<>();

        log.info("Fetching all laureates asynchronously from api in batches");
        for (int i = 0; i <= count; i += batchSize) {
            completableFutureList.add(execAPI(i, batchSize));
        }

        return completableFutureList.stream()
                .map(CompletableFuture::join)
                .map(this::parseCountryResponse)
                .flatMap(Collection::stream)
                .toList();
    }

    private List<String> parseCountryResponse(final Response response) {
        return getCountryList(response.getResponseBody()).stream()
                .map(s -> (String) s)
                .toList();
    }
}
