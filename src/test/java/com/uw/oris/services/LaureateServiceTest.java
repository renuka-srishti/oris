package com.uw.oris.services;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LaureateServiceTest {

    @Mock
    private AsyncHttpClient client;

    @Mock
    private BoundRequestBuilder boundRequestBuilder;

    @Mock
    private ListenableFuture<Response> listenableFuture;

    @Mock
    private CompletableFuture<Response> completableFuture;

    @Mock
    private Response response;

    private final String jsonString = "{\"laureates\":[{\"birth\":{\"place\":{\"country\":{\"en\":\"USA\"}}}}," +
            "{\"birth\":{\"place\":{\"country\":{\"en\":\"Denmark\"}}}}]," +
            "\"meta\":{\"count\":5}}";

    private LaureateService laureateService;

    @Before
    public void setUp() {
        when(client.prepareGet(anyString())).thenReturn(boundRequestBuilder);
        when(boundRequestBuilder.setHeader(anyString(), anyString())).thenReturn(boundRequestBuilder);
        when(boundRequestBuilder.setQueryParams(anyMap())).thenReturn(boundRequestBuilder);
        when(boundRequestBuilder.execute()).thenReturn(listenableFuture);
        when(listenableFuture.toCompletableFuture()).thenReturn(completableFuture);
        when(completableFuture.join()).thenReturn(response);
        when(response.getResponseBody()).thenReturn(jsonString);

        laureateService = new LaureateService();
        ReflectionTestUtils.setField(laureateService, "client", client);
    }

    @Test
    public void testGetLaureateCount_success() throws ExecutionException, InterruptedException {
        assertEquals(5, laureateService.getLaureateCount());
    }

    @Test(expected = Exception.class)
    public void testGetLaureateCount_throwsException() throws ExecutionException, InterruptedException {
        when(completableFuture.join()).thenThrow(ExecutionException.class);
        laureateService.getLaureateCount();
    }

    @Test
    public void testGetCountryForAllLaureates_success() throws ExecutionException, InterruptedException {
        assertEquals(Arrays.asList("USA", "Denmark"),
                laureateService.getCountryForAllLaureates());
    }

    @Test(expected = Exception.class)
    public void testGetCountryForAllLaureates_throwsException() throws ExecutionException, InterruptedException {
        when(completableFuture.join()).thenThrow(ExecutionException.class);
        laureateService.getCountryForAllLaureates();
    }
}