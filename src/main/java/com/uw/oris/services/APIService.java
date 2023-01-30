package com.uw.oris.services;

import com.uw.oris.services.dto.LaureateCount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

@Slf4j
@Service
@RequiredArgsConstructor
public class APIService {

    private final LaureateService laureateService;

    public List<LaureateCount> getLaureateCountByCountry() throws ExecutionException, InterruptedException {
        // fetch all laureates from API including paginated response
        log.info("Fetching countries for all laureates from api.");
        final List<String> laureates = laureateService.getCountryForAllLaureates();

        // sort list be frequency and return a sorted linked hashmap.
        log.info("Sorting countries by frequency.");
        Map<String, Integer> map = sortByFrequency(laureates);

        /** creating the required response structure.
         * [
         *  {
         *      "country": "xyz",
         *      "count" : x
         *  }
         * ]
         **/
        log.info("Preparing response.");
        final List<LaureateCount> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            result.add(new LaureateCount(e.getKey(), e.getValue()));
        }

        return result;
    }

    private Map<String, Integer> sortByFrequency(final List<String> laureates) {
        final Map<String, Integer> map = new HashMap<>();
        // calculating frequency
        for (String s : laureates) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // sorting by value in descending order
        return map.entrySet()
                .stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> v, LinkedHashMap::new)
                );
    }
}
