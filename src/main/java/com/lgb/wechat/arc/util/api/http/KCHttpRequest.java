package com.lgb.wechat.arc.util.api.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lgb.wechat.arc.util.api.json.kc.RestNowStudentCourseInfo;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KCHttpRequest {
    private static final String MANAGE_QUERY_KC_PREFIX = "http://www.56team.com:8080/manage/api/course/";
    private static final String MANAGE_QUERY_KC_SUFFIX = ".action";

    public static List<RestNowStudentCourseInfo> getManageKC(String stuCardNum) {

        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(MANAGE_QUERY_KC_PREFIX + stuCardNum + MANAGE_QUERY_KC_SUFFIX);

            get.setHeader("content-type", "application/json");
            get.setHeader("Accept", "application/json");

            response = closeableHttpClient.execute(get);
            Gson gson = new GsonBuilder().create();
            List<RestNowStudentCourseInfo> infos = gson.fromJson(
                    new JsonReader(
                            new BufferedReader(
                                    new InputStreamReader(
                                            response.getEntity().getContent()))), new TypeToken<List<RestNowStudentCourseInfo>>(){}.getType());

            closeableHttpClient.close();

            return infos;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
