package com.github.headnews;

//完成网络数据的请求与接收

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HeadNewsRequest {

    private String result = "";

    public String getRequestResult(String type) {

        //请求网络数据
        String host = "http://toutiao-ali.juheapi.com";
        String path = "/toutiao/index";
        String method = "GET";
        String appcode = "c2857f9ba38640728103156fee42c72e";

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("type", type);


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent(),"utf-8"));
            for (String s = reader.readLine(); s != null;s = reader.readLine()){
                result += s;
            }
            //result = EntityUtils.toString(response.getEntity());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

