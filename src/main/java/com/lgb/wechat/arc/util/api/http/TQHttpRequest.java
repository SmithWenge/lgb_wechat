package com.lgb.wechat.arc.util.api.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.lgb.wechat.arc.util.api.json.tq.TQSummary;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TQHttpRequest {
    private static final String BAIDU_QUERY_TQ_PREFIX = "http://api.map.baidu.com/telematics/v3/weather?location=";
    private static final String BAIDU_QUERY_TQ_SUFFIX = "&output=json&ak=A2477172a606cd1d90253aa4d7f3285f";

    public static TQSummary getBaiduTQ(String location) {
        if (null == location || location.trim().length() <= 0)
            location = "大连";

        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(BAIDU_QUERY_TQ_PREFIX + location + BAIDU_QUERY_TQ_SUFFIX);

            get.setHeader("content-type", "application/json");
            get.setHeader("Accept", "application/json");

            response = closeableHttpClient.execute(get);
            Gson gson = new GsonBuilder().create();
            TQSummary TQSummary = gson.fromJson(
                    new JsonReader(
                            new BufferedReader(
                                    new InputStreamReader(
                                            response.getEntity().getContent()))), TQSummary.class);

            closeableHttpClient.close();
            return TQSummary;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TQSummary();
    }
}
