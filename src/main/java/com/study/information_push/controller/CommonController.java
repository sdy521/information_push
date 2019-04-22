package com.study.information_push.controller;

import com.study.information_push.core.JSONResult;
import com.study.information_push.core.Result;
import com.study.information_push.dao.first.UserDao;
import com.study.information_push.entity.first.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author: Sdy
 * @Date:Created in 17:11 2019/4/19
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Resource
    private UserDao userDao;

    /***
     * 获取用户名
     * @param userid
     */
    @RequestMapping("/getUserName")
    @ResponseBody
    public Result getUserName(@RequestParam Integer userid){
        User user = new User();
        user.setId(userid);
        return new JSONResult(userDao.selectOne(user));
    }
}
