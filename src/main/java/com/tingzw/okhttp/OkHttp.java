package com.tingzw.okhttp;

import okhttp3.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author tingzw
 * @date 2017-04-12 10:02
 **/
public class OkHttp {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * okhttp get请求
     *
     * @throws Exception
     */
    @Test
    public void testGet() throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = "http://www.baidu.com";

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            System.out.println("服务端出错");
        }

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        System.out.println(response.body().string());
    }

    /**
     * okhttp post请求
     *
     * @throws Exception
     */
    @Test
    public void testPost() throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain");
        String postBody = "Hello World";

        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), new File("23"));

/*        RequestBody requestBody = new MultipartBuilder()
                .addFormDataPart("file", "head_image", fileBody)
                .addFormDataPart("imagetype", imageType)
                .addFormDataPart("userphone", userPhone)
                .build();*/

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .post(RequestBody.create(MEDIA_TYPE_TEXT, postBody))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }

        System.out.println(response.body().string());
    }

    @Test
    public void testAsyncGet() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();

        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("服务器端错误: " + response);
                }

                System.out.println("返回结果：" + response.body().string());
            }

        });

        System.out.println("=============");

    }

}
