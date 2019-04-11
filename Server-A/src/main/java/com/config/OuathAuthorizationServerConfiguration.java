package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * /**
 *@创建人:LiJinMing
 *@日期:2019-04-10 17:22
 *@描述: ouath认证服务器
 **/
@Configuration
@EnableAuthorizationServer
public class OuathAuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Value("${my.const.clientId}")
    private String clientId;

    @Value("${my.const.realm}")
    private String realm;

    @Autowired
    private TokenStore tokenStore;

   /* @Autowired
    private UserApprovalHandler userApprovalHandler;*/

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Value("${my.const.resourceId}")
    private String resourceId;

    /**
     * 实例化一个TokenStore，他的实现是InMemoryTokenStore，会把OAuth授权的token保存在内存中
     */
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        System.out.println("=====ouath.auth=====");
        clients.inMemory()
                .withClient(clientId)
                .resourceIds(resourceId)
                .scopes("select")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit","client_credentials")//此客户端可以使用的授权类型，默认为空。
                .authorities("client")
                .secret("123456")
                .accessTokenValiditySeconds(6000);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager);
    }


}
