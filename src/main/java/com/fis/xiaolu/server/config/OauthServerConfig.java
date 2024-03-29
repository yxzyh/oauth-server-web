package com.fis.xiaolu.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 用一句话描述这个类的作用
 * @author XiaoLu.Su 
 * @Date Oct 15, 2019
 */
@Configuration
@EnableAuthorizationServer
public class OauthServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(final ClientDetailsServiceConfigurer clients) 
  throws Exception {
    clients.inMemory()
        .withClient("handleCilentId")//客户端id
        .secret(passwordEncoder.encode("secret"))//客户端密钥
        .authorizedGrantTypes("authorization_code")//授权码模式
        .scopes("user_info") //授权范围
        .autoApprove(true)//开启自动授权
        .redirectUris("http://localhost:8882/login") //认证成功重定向
        .accessTokenValiditySeconds(10);//设置超时时间
  }
}