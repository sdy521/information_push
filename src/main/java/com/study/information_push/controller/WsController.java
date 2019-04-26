package com.study.information_push.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.information_push.core.Result;
import com.study.information_push.websocket.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sdy
 * @date 2019/4/24 17:18
 */
@Controller
@RequestMapping("/ws")
public class WsController {
    @RequestMapping("/sendNotice")
    @ResponseBody
    public Result sendNotice(String userid,String content,Integer radio){
        String color="";
        if(radio==0){
            color = "#DEDEDE";
        }else if(radio==1){
            color = "#EE7942";
        }else {
            color = "#EE2C2C";
        }
        Map<String,String> map = new HashMap<>();
        map.put("message",content);
        map.put("color",color);
        WebSocket webSocket = new WebSocket();
        if(userid.indexOf(",")!=-1){
            //指定多个发送
            webSocket.SpecifiedSending(Arrays.asList(userid.split(",")), JSONObject.toJSONString(map));
        }else {
            if(Integer.parseInt(userid)==0){
                //全体发送
                webSocket.GroupSending(JSONObject.toJSONString(map));
            }else {
                //单个发送
                webSocket.AppointSending(userid, JSONObject.toJSONString(map));
            }
        }
        return new Result();
    }
}
