package com.uw.oris.utils;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONUtil {

    public static int getCount(String body) {
        return JsonPath.parse(body).read("$.meta.count");
    }

    public static JSONArray getCountryList(String body) {
        return JsonPath.parse(body).read("$.laureates[*].birth.place.country.en");
    }
}
