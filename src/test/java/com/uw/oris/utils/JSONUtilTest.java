package com.uw.oris.utils;

import net.minidev.json.JSONArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSONUtilTest {

    private final String jsonString = "{\"laureates\":[{\"birth\":{\"place\":{\"country\":{\"en\":\"USA\"}}}}," +
            "{\"birth\":{\"place\":{\"country\":{\"en\":\"Denmark\"}}}}]," +
            "\"meta\":{\"count\":5}}";

    @Test
    public void testGetCount() {
        assertEquals(5, JSONUtil.getCount(jsonString));
    }

    @Test
    public void testGetCountryList() {
        final JSONArray jsonArray = new JSONArray();
        jsonArray.add("USA");
        jsonArray.add("Denmark");

        assertEquals(jsonArray, JSONUtil.getCountryList(jsonString));
    }
}