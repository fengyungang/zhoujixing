package com.zhoujixing.utils;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于封装 http get post 请求的方法
 */
public class HttpUtils {
    private static final Gson gson = new Gson();

    /**
     * 封装 get 请求
     * @param url  远程的路径
     * @param connectTimeout  设置连接超时的时间
     * @param requestTimeout  设置请求超时的时间
     * @param socketTimeout   设置Socket的连接时间
     * @return
     */
    public static Map<String,Object> doGET(String url,int connectTimeout,int requestTimeout,int socketTimeout){
        Map<String,Object> map = new HashMap<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout)//设置连接超时的时间
                .setConnectionRequestTimeout(requestTimeout)//设置请求超时的时间
                .setSocketTimeout(socketTimeout)//设置Socket的连接时间
                .setRedirectsEnabled(true)//允许自动重定向
                .build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200){
                String jsonResult = EntityUtils.toString(httpResponse.getEntity());
                map = gson.fromJson(jsonResult,map.getClass());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();//关闭客户端
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 封装post
     * @param url
     * @param data
     * @param connectTimeout 设置连接超时的时间
     * @param requestTimeout 设置请求超时的时间
     * @param socketTimeout 设置Socket的连接时间
     * @return
     */
    public static  String doPost(String url,String data,int connectTimeout,int requestTimeout,int socketTimeout){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(requestTimeout)
                .setSocketTimeout(requestTimeout)
                .setRedirectsEnabled(true)
                .build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type","text/html; chartest=UTF-8");
        if (data !=null && data instanceof String){
            StringEntity stringEntity = new StringEntity(data,"UTF-8");
            httpPost.setEntity(stringEntity);
        }
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpResponse.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(httpEntity);
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
