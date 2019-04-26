package com.study.information_push.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.information_push.core.Constants;
import com.study.information_push.core.Result;
import com.study.information_push.dao.second.UserNoticeDao;
import com.study.information_push.util.RedisUtil;
import com.study.information_push.websocket.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author sdy
 * @date 2019/4/24 17:18
 */
@Controller
@RequestMapping("/ws")
public class WsController {
    @Resource
    private UserNoticeDao userNoticeDao;

    @RequestMapping("/sendNotice")
    @ResponseBody
    public Result sendNotice(String userid,String content,Integer radio,String noticeid){
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
            List<String> list = Arrays.asList(userid.split(","));
            //指定多个发送
            webSocket.SpecifiedSending(list, JSONObject.toJSONString(map));
            for(String user : list){
                userNoticeDao.insertOne(Integer.parseInt(user),Integer.parseInt(noticeid));
            }
        }else {
            if(Integer.parseInt(userid)==0){
                //全体发送
                webSocket.GroupSending(JSONObject.toJSONString(map));
                Set<Object> set = (HashSet<Object>) RedisUtil.MEMBERS(Constants.USER_WEBSOCKET).stream().findFirst().get();
                for(Object user : set){
                    userNoticeDao.insertOne(Integer.parseInt(user.toString()),Integer.parseInt(noticeid));
                }
            }else {
                //单个发送
                webSocket.AppointSending(userid, JSONObject.toJSONString(map));
                userNoticeDao.insertOne(Integer.parseInt(userid),Integer.parseInt(noticeid));
            }
        }
        return new Result();
    }
}
