package com.zhuhai.http;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/26
 * Time: 21:00
 *
 * @author: hai
 */
public class HttpTest {

    private static final String URL = "http://218.241.86.18:8010/area/query";


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        //GET请求
        //Request request = new Request.Builder().url(URL).build();
        //MediaType mediaType = MediaType.parse("text/plain");
        //POST请求
        RequestBody requestBody = new FormBody.Builder().add("pid", "1101").build();
        Request request = new Request.Builder().url(URL).post(requestBody).build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            System.out.println("服务器端异常：" + response);
        }
        Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            System.out.println(headers.name(i) + ":" + headers.value(i));
        }
        String result = response.body().string();
        System.out.println(result);
    }

}
