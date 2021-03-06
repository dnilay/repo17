package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UsersService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	/*
	 * private Environment environment; private UsersService usersService; private
	 * BCryptPasswordEncoder bCryptPasswordEncoder;
	 * 
	 * @Autowired public WebSecurity(Environment environment, UsersService
	 * usersService, BCryptPasswordEncoder bCryptPasswordEncoder) { this.environment
	 * = environment; this.usersService = usersService; this.bCryptPasswordEncoder =
	 * bCryptPasswordEncoder; }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http .authorizeRequests() .anyRequest().permitAll().and() .formLogin().and()
		 .httpBasic();
		http.headers().frameOptions().disable();
	}
	
	
}
