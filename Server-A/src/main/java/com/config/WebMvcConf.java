package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConf implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*registry.addViewController("/error/401").setViewName("/401 没权限");
        registry.addViewController("/error/404").setViewName("/404 找不到页面");*/
        registry.addViewController("/test/1").setViewName("/1111111");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");

    }
}
