package com.study.information_push.controller;

import com.github.pagehelper.PageInfo;
import com.study.information_push.core.*;
import com.study.information_push.entity.second.User;
import com.study.information_push.service.PushConfigService;
import com.study.information_push.util.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: Sdy
 * @Date:Created in 21:11 2019/4/18
 * 推送配置
 */
@Controller
@RequestMapping("/push_config")
public class PushConfigController {

    @Resource
    private PushConfigService pushConfigService;
    @RequestMapping("/list")
    public String list(){
        return "/modular/pushConfig/list";
    }

    @RequestMapping("/layuiTable")
    @ResponseBody
    public Result layuiTable(LayuiPageParam pageParam){
        String ids = "";
        PageInfo<User> pageInfo = null;
        if(RedisUtil.HASKEY(Constants.USER_WEBSOCKET)){
            Set<Object> set = (HashSet<Object>)RedisUtil.MEMBERS(Constants.USER_WEBSOCKET).stream().findFirst().get();
            if(set!=null&&set.size()>0){
                for(Object id : set){
                    ids += id+",";
                }
                pageInfo = pushConfigService.selectByIds(pageParam,ids.substring(0,ids.length()-1));
            }else {
                pageInfo = pushConfigService.selectByIds(pageParam,"0");
            }
        }else {
            pageInfo = pushConfigService.selectByIds(pageParam,"0");
        }
        return new PageResult(pageInfo.getList(),pageInfo.getTotal());
    }

    /***
     * 实时查询redis
     * @return
     */
    @RequestMapping(value = "/getRedis")
    @ResponseBody
    public Result getRedis(){
        if(RedisUtil.HASKEY(Constants.USER_WEBSOCKET)){
            Set<Object> set = (HashSet<Object>)RedisUtil.MEMBERS(Constants.USER_WEBSOCKET).stream().findFirst().get();
            if(set!=null&&set.size()>0){
                return new JSONResult(set.size());
            }else {
                return new JSONResult(0);
            }
        }else {
            return new JSONResult(0);
        }
    }
}
