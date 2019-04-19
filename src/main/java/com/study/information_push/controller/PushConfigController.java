package com.study.information_push.controller;

import com.github.pagehelper.PageInfo;
import com.study.information_push.core.JSONResult;
import com.study.information_push.core.LayuiPageParam;
import com.study.information_push.core.PageResult;
import com.study.information_push.core.Result;
import com.study.information_push.entity.PushConfig;
import com.study.information_push.service.PushConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(@RequestParam Integer id){
        PushConfig pushConfig = new PushConfig();
        pushConfig.setId(id);
        pushConfigService.delete(pushConfig);
        return new Result();
    }
}
