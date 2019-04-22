package com.study.information_push.controller;

import com.github.pagehelper.PageInfo;
import com.study.information_push.core.*;
import com.study.information_push.entity.first.PushConfig;
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
        PageInfo<PushConfig> pageInfo = pushConfigService.seletAll(pageParam);
        return new PageResult(pageInfo.getList(),pageInfo.getTotal());
    }

    /***
     * 编辑界面
     * @return
     */
    @RequestMapping("/editModal")
    @ResponseBody
    public Result editModal(@RequestParam Integer id){
        PushConfig pushConfig = new PushConfig();
        pushConfig.setId(id);
        PushConfig pc = pushConfigService.selectOne(pushConfig);
        return new JSONResult(pc);
    }

    /***
     * 编辑确认
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Result edit(@RequestParam Integer id,@RequestParam String url,@RequestParam String method){
        PushConfig pushConfig = new PushConfig();
        pushConfig.setId(id);
        pushConfig.setUrl(url);
        pushConfig.setMethod(method);
        pushConfigService.updateByPrimaryKeySelective(pushConfig);
        return new Result();
    }

    /***
     * 添加配置
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(@RequestParam String url,@RequestParam String method){
        PushConfig pushConfig = new PushConfig();
        pushConfig.setUrl(url);
        pushConfig.setMethod(method);
        pushConfigService.insert(pushConfig);
        return new Result();
    }

    /***
     * 添加配置
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(Integer[] ids){
        for(int i=0;i<ids.length;i++){
            Integer id = ids[i];
            PushConfig pushConfig = new PushConfig();
            pushConfig.setId(id);
            pushConfigService.delete(pushConfig);
        }
        return new Result();
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
