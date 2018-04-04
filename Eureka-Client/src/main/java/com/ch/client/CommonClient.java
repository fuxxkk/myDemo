package com.ch.client;

import com.ch.client.fallback.CommonClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *@创建人:LiJinMing
 *@日期:2018/4/4 下午5:59
 *@描述:Common工程服务接口
 **/
@FeignClient(name = "CommonService",fallback = CommonClientFallback.class) //在注册中心对应名字的服务
public interface CommonClient {

    @RequestMapping("/setredis")
    public String setRedis(@RequestParam(value = "key") String key,@RequestParam(value = "val") String val);

    @RequestMapping("/getredis")
    public String getRedis(@RequestParam(value = "key")String key);

    @RequestMapping(value = "/hello")
    public String hello();
}
