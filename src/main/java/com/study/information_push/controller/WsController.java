package com.study.information_push.controller;

import com.study.information_push.core.Result;
import com.study.information_push.websocket.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sdy
 * @date 2019/4/24 17:18
 */
@Controller
@RequestMapping("/ws")
public class WsController {
    @RequestMapping("/sendNotice")
    @ResponseBody
    public Result sendNotice(String userid,String content){
        WebSocket webSocket = new WebSocket();
        webSocket.AppointSending(userid,content);
        return new Result();
    }
}
