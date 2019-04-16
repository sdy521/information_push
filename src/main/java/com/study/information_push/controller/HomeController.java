package com.study.information_push.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sdy
 * @date 2019/4/16 15:54
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }
}
