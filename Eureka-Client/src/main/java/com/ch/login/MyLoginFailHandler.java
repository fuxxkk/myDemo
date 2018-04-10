package com.ch.login;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class MyLoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println("登录失败");
        httpServletRequest.setAttribute("error",e.getMessage());
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        System.out.println("MyLoginFailHandler----"+username+"___"+password);
        httpServletRequest.setAttribute("password",password);
        httpServletRequest.setAttribute("username",username);
        httpServletRequest.getRequestDispatcher("index_error").forward(httpServletRequest,httpServletResponse);
        //httpServletResponse.sendRedirect("/login?error=fail");

    }
}
