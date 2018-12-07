package com.cssl.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;
import java.util.Map;

@Controller
public class CallBackServlet {


    @RequestMapping("/callBack")
    public void callback(Map<String,Object> map) throws IOException {
        String code=map.get("code").toString();
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=" +AuthUtil.APPID
               + "&secret=" +AuthUtil.APPSECRET
                +        "&code=" +code
                +"&grant_type=authorization_code";
        JSONObject jsonObject = AuthUtil.doGetJson(url);
        String token = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");
        String infoUrl="https://api.weixin.qq.com/sns/userinfo?access_token=" +token
               + "&openid=" +openid
               + "&lang=zh_CN";
        JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
        System.out.println("userInfo:"+userInfo);

    }
}
