package com.study.information_push.controller;

import com.study.information_push.core.JSONResult;
import com.study.information_push.core.Result;
import com.study.information_push.entity.PushConfig;
import com.study.information_push.service.PushConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Result layuiTable(){
        PushConfig pushConfig = new PushConfig();
        pushConfig.setDeleted(false);
        List<PushConfig> list = pushConfigService.select(pushConfig);
        return new JSONResult(list,list.size());
    }
}
