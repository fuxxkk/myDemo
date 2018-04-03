package com.ch.service.impl;

import com.ch.entity.TestUser;
import com.ch.mapper.TestMapper;
import com.ch.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestUser> getTestUser() {
        return testMapper.queryTime();
    }
}
