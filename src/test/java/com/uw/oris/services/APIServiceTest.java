package com.uw.oris.services;

import com.uw.oris.services.dto.LaureateCount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class APIServiceTest {

    @Mock
    private LaureateService laureateService;

    private APIService apiService;

    private final List<String> countries = Arrays.asList("USA", "Denmark", "USA", "USA");
    private final List<LaureateCount> laureateCounts = Arrays.asList(
            new LaureateCount("USA", 3),
            new LaureateCount("Denmark", 1)
    );

    @Before
    public void setUp() throws Exception {
        apiService = new APIService(laureateService);
        when(laureateService.getCountryForAllLaureates()).thenReturn(countries);
    }

    @Test
    public void testGetLaureateCountByCountry_success() throws ExecutionException, InterruptedException {
        List<LaureateCount> laureateCountList = apiService.getLaureateCountByCountry();
        assertEquals(laureateCounts, laureateCountList);
    }

    @Test(expected = Exception.class)
    public void testGetLaureateCountByCountry_throwsException() throws ExecutionException, InterruptedException {
        when(laureateService.getCountryForAllLaureates()).thenThrow(ExecutionException.class);
        apiService.getLaureateCountByCountry();
    }
}