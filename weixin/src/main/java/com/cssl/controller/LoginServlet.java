package com.cssl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
public class LoginServlet {

    @RequestMapping("/wxLogin")
    public String doget(){
        String backUrl="http://134.175.102.188:8080/weixin/callBack";
        String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +AuthUtil.APPID
                +"&redirect_uri=REDIRECT_URI" + URLEncoder.encode(backUrl)
                +"&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        System.out.println("进来了wxlogin=================================================>");
        return "redirect:"+url;
    }

}
