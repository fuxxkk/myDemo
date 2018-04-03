package com.ch.redis.impl;

import com.ch.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.naming.Name;

@Service
public class RedisServiceImp implements RedisService {

    @Resource(name="jedis")
    private JedisPool jedisPool;

    @Override
    public void set(String key, String val) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key,val);
        jedis.close();
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String val = jedis.get(key);
        jedis.close();
        return val;
    }
}
