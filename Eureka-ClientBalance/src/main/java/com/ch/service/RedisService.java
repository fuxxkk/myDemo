package com.ch.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 *@创建人:LiJinMing
 *@日期:2018/4/4 上午10:53
 *@描述:负责springcloud的负载均衡类
 **/
@Service
public class RedisService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "setRedisFallback")  //Get请求调用服务，restTemplate被@LoadBalanced注解标记，Get方法会自动进行负载均衡
    public void setRedis(String key,String val) {

        restTemplate.getForObject("http://CommonService/setredis?key="+key+"&val="+val, String.class);//别用有第三个参数的方法,试过会报错,日后再研究
    }

    //容错方法
    public void setRedisFallback(String key,String val) {

        System.out.println("============插入失败!============");
    }

    @HystrixCommand(fallbackMethod = "getRedisFallback") //查找容错方法
    public String getRedis(String key) {
        String result = restTemplate.getForObject("http://CommonService/getredis?key="+key, String.class);
        return result;

    }
    //容错方法
    public String getRedisFallback(String key) {
        return "==========获取失败==========";
    }

    @HystrixCommand(fallbackMethod = "helloFallback") //对于容错方法名字
    public String hello() {
        return restTemplate.getForObject("http://CommonService/hello", String.class);
    }

    //容错方法
    public String helloFallback() {
        return "error!";
    }
}
