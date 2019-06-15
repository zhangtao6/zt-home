package com.zhangtao.zt.home.commons.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author zhangtao
 * @Description: HttpClient工具类
 * @ProjectName zt-home
 * @date 2019/6/13 9:41
 */
public class HttpClientUtils {

    public static final String GET = "get";
    public static final String POST = "post";

    public static final String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36";

    /**
     * Get请求，不带cookie
     * @param url
     * @return
     */
    public static String doGet(String url) {
        return createRequest(url, GET, null);
    }

    /**
     * Get请求，带cookie
     * @param url
     * @param cookie
     * @return
     */
    public static String doGet(String url, String cookie) {
        return createRequest(url, GET, cookie);
    }

    /**
     * Post请求， 不带cookie
     * @param url
     * @param params post请求的参数
     * @return
     */
    public static String doPost(String url, BasicNameValuePair... params) {
        return createRequest(url, POST, null, params);
    }
    /**
     * Post请求，带cookie
     * @param url
     * @param params post请求的参数
     * @return
     */
    public static String doPost(String url, String cookie, BasicNameValuePair... params) {
        return createRequest(url, POST, cookie, params);
    }

    /**
     * 创建请求
     * @param url 请求地址
     * @param requestMethod 请求方式
     * @param cookie 请求cookie
     * @param params 请求参数
     * @return json字符串形式的返回值
     */
    private static String createRequest(String url, String requestMethod, String cookie, BasicNameValuePair... params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //请求结果
        String result = null;
        try {


            //请求方式
            HttpGet httpGet = null;
            HttpPost httpPost = null;
            //响应
            CloseableHttpResponse httpResponse = null;

            //get请求
            if (GET.equals(requestMethod)) {
                //获取请求
                httpGet = new HttpGet(url);
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpGet.setHeader("Cookie", cookie);
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                //进行请求，获取响应

                httpResponse = httpClient.execute(httpGet);
            }
            //post请求
            else if (POST.equals(requestMethod)) {
                httpPost = new HttpPost(url);
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpPost.setHeader("Cookie", cookie);
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);

                //判断参数是否为空，不为空传入参数

                httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params), "UTF-8"));
                //进行请求，获取响应

                httpResponse = httpClient.execute(httpPost);
            }

            //获取响应
            HttpEntity httpEntity = httpResponse.getEntity();

            result = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
