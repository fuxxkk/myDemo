package com.ch.mapper;

import com.ch.entity.TestUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    public List<TestUser> queryTime();
}
