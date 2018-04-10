package com.ch.controller;

import com.ch.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/setredis")
    public String setRedis(@RequestParam String key, @RequestParam String val) {
        redisService.set(key,val);
        return "success!";
    }

    @GetMapping("/getredis")
    public String getRedis(@RequestParam String key) {
        return redisService.get(key);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}