package com.ch.controller;

import com.ch.client.CommonClient;
import com.ch.entity.TestUser;
import com.ch.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
public class MyController {

  @Value("${server.port}")
  String port;

  @Autowired
  private TestService testService;
  @Autowired
  private CommonClient commonClient;

  @ResponseBody
  @RequestMapping("/hi")
  public String HelloWrold(String name){

    List<TestUser> testUser = testService.getTestUser();
    for (TestUser tu :
            testUser) {
      System.out.println(tu.getId()+"..."+tu.getUsername());
    }

    return "Hi"+name+",i am from port"+this.port;
  }

  @RequestMapping("/setredis/{key}/{val}")
  @ResponseBody
  public String setRedis(@PathVariable("key")String key,@PathVariable("val")String val) {
    return commonClient.setRedis(key, val);
  }

  @RequestMapping("/getredis/{key}")
  public String getRedis(@PathVariable("key")String key) {
    return commonClient.getRedis(key);
  }

  @RequestMapping("/hello")
  public String hello() {
    return commonClient.hello();
  }


}
