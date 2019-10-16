package com.fis.xiaolu.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 用一句话描述这个类的作用
 * @author XiaoLu.Su 
 * @Date Oct 15, 2019
 */
@Configuration
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.requestMatchers()
	      .antMatchers("/login")
	      .antMatchers("/oauth/authorize")
	      .and()
	      .authorizeRequests()
	      .anyRequest().authenticated()
	      .and()
	      .formLogin().loginPage("/login").permitAll()
	      .and().csrf().disable();
	  }

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    //使用内存模拟数据库查询的用户
	    auth.inMemoryAuthentication() //内存认证
	      .withUser("admin")//admin 内存认证用户名
	      .password(passwordEncoder().encode("123456"))//被加密的123456密码
	      .roles("ADMIN");//ROLE_ADMIN的角色
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
}
