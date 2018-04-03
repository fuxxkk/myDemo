package com.ch.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Value("${server.port}")
  String port;
  @ResponseBody
  @RequestMapping("/hi")
  public String HelloWrold(String name){
    return "Hi"+name+",i am from port"+this.port;
  }

}
