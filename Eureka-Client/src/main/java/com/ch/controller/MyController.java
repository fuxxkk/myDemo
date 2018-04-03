package com.ch.controller;

import com.ch.entity.TestUser;
import com.ch.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

  @Value("${server.port}")
  String port;

  @Autowired
  private TestService testService;


  @ResponseBody
  @RequestMapping("/hi")
  public String HelloWrold(String name){

    List<TestUser> testUser = testService.getTestUser();
    for (TestUser tu :
            testUser) {
      System.out.println(tu.getId()+"..."+tu.getName());
    }

    return "Hi"+name+",i am from port"+this.port;
  }

}
