package com.ch.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *@创建人:LiJinMing
 *@日期:2018/4/8 下午2:58
 *@描述: 测试spring security
 **/
@RestController
@EnableWebSecurity
public class SecurityController {


    @RequestMapping("/scu")
    public String security() {
        return "hello world security";
    }

    @RequestMapping("/index_error")
    public ModelAndView login_page() {
        return new ModelAndView("index_error");
    }

    @RequestMapping(value = "/loginerror",method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("error", "用户或密码错误");
        return mv;
    }
    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        //mv.addObject("error", "用户或密码错误");
        //System.out.println("登出成功");
        return mv;
    }
}
