package com.lgb.wechat.arc.util.api.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lgb.wechat.arc.util.api.json.kc.RestNowStudentCourseInfo;
import com.lgb.wechat.arc.util.api.json.rq.RQSummary;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RQHttpRequest {
    private static final String JHSJ_QUERY_RQ_PREFIX = "http://v.juhe.cn/laohuangli/d?date=";
    private static final String JHSJ_QUERY_RQ_SUFFIX = "&key=ba666c34e89ed5ed0298e417ef25cdae";

    public static RQSummary getDateInfo(String date) {

        CloseableHttpResponse response = null;

        try {
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(JHSJ_QUERY_RQ_PREFIX + date + JHSJ_QUERY_RQ_SUFFIX);

            get.setHeader("content-type", "application/json");
            get.setHeader("Accept", "application/json");

            response = closeableHttpClient.execute(get);
            Gson gson = new GsonBuilder().create();
            RQSummary rqSummary = gson.fromJson(
                    new JsonReader(
                            new BufferedReader(
                                    new InputStreamReader(
                                            response.getEntity().getContent()))), RQSummary.class);

            closeableHttpClient.close();

            return rqSummary;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new RQSummary();
    }
}
