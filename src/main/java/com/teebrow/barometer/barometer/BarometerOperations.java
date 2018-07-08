package com.teebrow.barometer.barometer;

import com.teebrow.barometer.model.BarometerRequestModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author dsinha003c
 */
public class BarometerOperations {

    public String detectOutliers(BarometerRequestModel requestModel) {
        JsonObject data = new JsonObject();
        JsonArray xAxis = new JsonArray();
        xAxis.add("2018-07-06 00:00:00");
        xAxis.add("2018-07-06 00:01:00");
        xAxis.add("2018-07-06 00:02:00");
        xAxis.add("2018-07-06 00:03:00");
        xAxis.add("2018-07-06 00:04:00");
        xAxis.add("2018-07-06 00:05:00");
        JsonArray yAxis = new JsonArray();
        yAxis.add(2);
        yAxis.add(3);
        yAxis.add(2);
        yAxis.add(10);
        yAxis.add(1);
        yAxis.add(3);
        data.add("x-axis", xAxis);
        data.add("y-axis", yAxis);
        return data.toString();
    }
}
