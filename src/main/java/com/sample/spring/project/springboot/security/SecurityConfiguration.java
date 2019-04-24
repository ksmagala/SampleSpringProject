package com.sample.spring.project.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService jpaUserDetailsService(){
        return new CustomUserDetailsService();
    }

    protected void configure(HttpSecurity security) throws Exception{
        security.authorizeRequests()
                .antMatchers("/", "/api/user/**").permitAll()
                .and().formLogin().permitAll()
                .and().logout().permitAll();
    }
}
