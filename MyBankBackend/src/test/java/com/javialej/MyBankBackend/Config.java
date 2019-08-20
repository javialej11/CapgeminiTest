package com.javialej.MyBankBackend;

import java.util.Collections;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@TestConfiguration
public class Config {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User basicTestUser = new User(
                "javialej",
                "javialej",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

        return new InMemoryUserDetailsManager(basicTestUser);
    }
}