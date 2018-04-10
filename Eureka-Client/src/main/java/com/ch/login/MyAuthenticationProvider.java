package com.ch.login;

import com.ch.entity.TestUser;
import com.ch.service.impl.LoginUserServiceImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 *@创建人:LiJinMing
 *@日期:2018/4/9 下午3:13
 *@描述:自定义验证器
 **/
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Resource(name="LoginUserServiceImpl")
    private LoginUserServiceImpl loginUserService;

    //自定义认证方法
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        TestUser user = (TestUser) loginUserService.loadUserByUsername(username);

        if (!user.getPassword().equals(password)) {
            System.out.println("密码错误");
            throw new BadCredentialsException("用户或密码错误");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        System.out.println("登录成功");
        //TODO 保存到redis

        return new UsernamePasswordAuthenticationToken(user,password,authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
