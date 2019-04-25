package com.study.information_push.websocket;

import com.study.information_push.core.Constants;
import com.study.information_push.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author sdy
 * @date 2019/4/17 16:49
 *
 * @ServerEndpoint 这个注解有什么作用？
 *
 * 这个注解用于标识作用在类上，它的主要功能是把当前类标识成一个WebSocket的服务端
 * 注解的值用户客户端连接访问的URL地址
 *
 */
@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocket {
    /**
     *  与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    /**
     *  用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static ConcurrentHashMap<String,WebSocket> webSocketSet = new ConcurrentHashMap<>();

    private Logger log = LoggerFactory.getLogger(WebSocket.class);

    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name){
        this.session = session;
        // name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        webSocketSet.put(name,this);
        //存入redis
        String key = Constants.USER_WEBSOCKET;
        if(RedisUtil.HASKEY(key)){
            //不存在该用户  需要再次添加
           if(!RedisUtil.ISMEMBER(key,name)){
               Set<Object> setRedis = RedisUtil.MEMBERS(key);
               Set<Object> set = (HashSet<Object>)setRedis.stream().findFirst().get();
               set.add(name);
               RedisUtil.DEL(key);
               RedisUtil.ADDSET(key,set);
           }
        }else {
            Set<Object> set = new HashSet<Object>();
            set.add(name);
            RedisUtil.ADDSET(key,set);
        }
        log.info("[WebSocket] 连接成功，当前连接人数为：={}",webSocketSet.size());
    }

    @OnClose
    public void OnClose(){
        Map<String, List<String>> paramMap = session.getRequestParameterMap();
        String key = Constants.USER_WEBSOCKET;
        if(paramMap!=null){
            for (Map.Entry<String,List<String>> entry : paramMap.entrySet()){
                String value = entry.getValue().get(0);
                webSocketSet.remove(value);
                //删除redis
                Set<Object> set = (HashSet<Object>)RedisUtil.MEMBERS(key).stream().findFirst().get();
                set = set.stream().filter(o -> !o.equals(value)).collect(Collectors.toSet());
                RedisUtil.DEL(key);
                RedisUtil.ADDSET(key,set);
            }
        }
        log.info("[WebSocket] 退出成功，当前连接人数为：={}",webSocketSet.size());
    }

    @OnMessage
    public void OnMessage(String message){
        log.info("[WebSocket] 收到消息：{}",message);
    }

    /**
     * 群发
     * @param message
     */
    public void GroupSending(String message){
        for (String name : webSocketSet.keySet()){
            try {
                webSocketSet.get(name).session.getBasicRemote().sendText("service返回信息:"+message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定发送
     * @param name
     * @param message
     */
    public void AppointSending(String name,String message){
        try {
            webSocketSet.get(name).session.getBasicRemote().sendText(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
