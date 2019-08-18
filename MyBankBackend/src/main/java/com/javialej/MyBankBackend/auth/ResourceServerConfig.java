package com.javialej.MyBankBackend.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.javialej.MyBankBackend.MyBankBackendApplication;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, MyBankBackendApplication.API + "/customer/").permitAll()
		.antMatchers(HttpMethod.POST, MyBankBackendApplication.API + "/customer/sign-up").permitAll()
		.anyRequest().authenticated();
	}
	
	
}
