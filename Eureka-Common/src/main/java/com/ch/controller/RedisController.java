package com.ch.controller;

import com.ch.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/setredis")
    public String setRedis(@RequestParam String key, @RequestParam String val) {
        redisService.set(key,val);
        return "success!";
    }
}
