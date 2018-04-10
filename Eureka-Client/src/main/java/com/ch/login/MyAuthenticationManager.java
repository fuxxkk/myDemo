package com.ch.login;

import com.ch.entity.TestUser;
import com.ch.service.impl.LoginUserServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

@Component
public class MyAuthenticationManager implements AuthenticationManager {

    @Resource(name="LoginUserServiceImpl")
    private LoginUserServiceImpl loginUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        TestUser user = (TestUser) loginUserService.loadUserByUsername(username);

        if (!user.getPassword().equals(password)) {
            System.out.println("manage--密码错误");
            throw new BadCredentialsException("用户或密码错误");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        System.out.println("manage--登录成功");
        //TODO 保存到redis

        return new UsernamePasswordAuthenticationToken(user,password,authorities);
    }
}
