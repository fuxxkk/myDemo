package com.ch.service.impl;

import com.ch.entity.TestUser;
import com.ch.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("LoginUserServiceImpl")
public class LoginUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TestUser user = userMapper.getLoginUSer(s);
        if (user==null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        System.out.println("username input:"+s);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
