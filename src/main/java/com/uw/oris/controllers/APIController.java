package com.uw.oris.controllers;


import com.uw.oris.services.APIService;
import com.uw.oris.services.dto.LaureateCount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class APIController {

    private final APIService apiService;

    @GetMapping("/laureate-count")
    public List<LaureateCount> laureateCountByCountry() throws ExecutionException, InterruptedException {
        log.info("Request to /laureate-count is submitted");
        return apiService.getLaureateCountByCountry();
    }
}
