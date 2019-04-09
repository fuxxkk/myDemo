package com.service.impl;

import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String hello() {

        String helloStr = restTemplate.getForObject("http://server-a/test/hello", String.class);

        return helloStr+"b";
    }
}
