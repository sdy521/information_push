package com.study.information_push.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Sdy
 * @Date:Created in 22:17 2019/4/16
 */
@Controller
public class RegisterController {

    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }
}
