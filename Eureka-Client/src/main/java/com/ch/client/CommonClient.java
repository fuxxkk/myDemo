package com.ch.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CommonService")
public interface CommonClient {

    @RequestMapping("/setredis")
    public String setRedis(@RequestParam(value = "key") String key,@RequestParam(value = "val") String val);
}
