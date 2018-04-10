package com.ch.conf;

import com.ch.service.impl.LoginUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService customUserservice() {
        return new LoginUserServiceImpl();
    }

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private AuthenticationManager authenticationManager;

    /*定义认证用户信息获取来源，密码校验规则等*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println(auth);
//        auth.userDetailsService(customUserservice()); //使用userdetailservice认证
        //auth.inMemoryAuthentication().withUser("user").password("1234").roles("user");
        auth.parentAuthenticationManager(authenticationManager);//使用自定义认证

    }

    //安全策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//配置安全策略
            .antMatchers("/loginerror","/login","/js/**","/image/**","/validatecode","/index_error").permitAll()  //"/","/hello"都不用验证
            .anyRequest().authenticated() //其余的请求都要验证u
            .and()
            .logout().logoutSuccessHandler(logoutSuccessHandler).logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()//定义logout不需要验证
            .and()
            .formLogin().loginPage("/login").failureHandler(authenticationFailureHandler).defaultSuccessUrl("/scu")//.failureForwardUrl("/loginerror")//.defaultSuccessUrl("/scu")////使用form表单登录
            .and()
            .csrf().disable();//取消csrf表单验证(get提交可以不取消)

    }
}
