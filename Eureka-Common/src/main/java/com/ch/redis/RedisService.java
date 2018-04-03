package com.ch.redis;

public interface RedisService {
    public void set(String key, String val);

    public String get(String key);

}
