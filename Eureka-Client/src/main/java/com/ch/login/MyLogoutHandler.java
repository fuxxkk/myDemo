package com.ch.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *@创建人:LiJinMing
 *@日期:2018/4/10 上午10:11
 *@描述:自定义登出处理类
 **/
@Component
public class MyLogoutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //TDO 删除redis数据

        System.out.println("登出成功");
        httpServletResponse.sendRedirect("/login");
    }
}
