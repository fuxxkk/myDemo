package com.ch.mapper;

import com.ch.entity.TestUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    TestUser getLoginUSer(String username);
}
