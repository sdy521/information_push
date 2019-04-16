package com.study.information_push.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Sdy
 * @Date:Created in 22:17 2019/4/16
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
