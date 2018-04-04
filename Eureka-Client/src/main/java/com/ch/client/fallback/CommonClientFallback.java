package com.ch.client.fallback;

import com.ch.client.CommonClient;
/**
 *@创建人:LiJinMing
 *@日期:2018/4/4 下午5:59
 *@描述:Common容错类
 **/
public class CommonClientFallback implements CommonClient {
    @Override
    public String setRedis(String key, String val) {
        return null;
    }

    @Override
    public String getRedis(String key) {
        return null;
    }

    @Override
    public String hello() {
        return "error!";
    }
}
