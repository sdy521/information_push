package com.study.information_push.test;

import com.study.information_push.core.JSONResult;
import com.study.information_push.core.Result;
import com.study.information_push.dao.second.UserDao2;
import com.study.information_push.entity.second.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sdy
 * @date 2019/4/22 16:17
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private UserDao2 userDao2;

    @RequestMapping("/test")
    @ResponseBody
    public Result test(){
        List<User> list = userDao2.selectAll();
        return new JSONResult(list);
    }
}
