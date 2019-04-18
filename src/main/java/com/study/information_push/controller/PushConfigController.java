package com.study.information_push.controller;

import com.study.information_push.core.JSONResult;
import com.study.information_push.core.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/list")
    public String list(){
        return "/modular/pushConfig/list";
    }

    @RequestMapping("/layuiTable")
    @ResponseBody
    public Result layuiTable(){
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("id","1");
        map.put("username","admin");
        map.put("email","1036623663@qq.com");
        map.put("sex","男");
        map.put("city","江苏南京");
        map.put("sign","1");
        map.put("experience","1");
        map.put("ip","192.168.248.226");
        map.put("logins","1");
        map.put("joinTime","1");
        map.put("right","1");
        list.add(map);
        Map map1 = new HashMap();
        map1.put("id","2");
        map1.put("username","admin");
        map1.put("email","1036623663@qq.com");
        map1.put("sex","男");
        map1.put("city","江苏南京");
        map1.put("sign","2");
        map1.put("experience","2");
        map1.put("ip","192.168.248.226");
        map1.put("logins","2");
        map1.put("joinTime","2");
        map1.put("right","2");
        list.add(map1);
        return new JSONResult(list);
    }
}
