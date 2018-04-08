package com.ch.controller;

import com.ch.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/setredis")
    public String setRedis(@RequestParam String key, @RequestParam String val) {
        redisService.setRedis(key,val);
        return "插入成功";
    }

    @RequestMapping("/getredis")
    public String getRedis(@RequestParam String key) {
        return redisService.getRedis(key);
    }

    @RequestMapping("/hello")
    public String hello() {
        return redisService.hello();
    }
}
