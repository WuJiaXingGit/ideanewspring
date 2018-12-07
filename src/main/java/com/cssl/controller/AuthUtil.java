package com.cssl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class AuthUtil {
    /**
     *添加了注释我爱你
     */

    public static final String APPID="wxdf60633cea3de308";
    public static final String APPSECRET="dcb86267dc71b81be1ac02fbea1c6f1d";

    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject=null;
        DefaultHttpClient client=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet(url);
       HttpResponse execute = client.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        if(entity!=null){
            String s = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.parseObject(s);
        }
        httpGet.releaseConnection();
        System.out.println("jsonobjece:"+jsonObject);
        return jsonObject;
    }
}
