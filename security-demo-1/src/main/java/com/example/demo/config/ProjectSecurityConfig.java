package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("admin").password("12345").authorities
	 * ("admin").and(). withUser("user").password("12345").authorities("user").and()
	 * .passwordEncoder(NoOpPasswordEncoder.getInstance()); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
		 * Secured /notices - Not Secured /contact - Not Secured
		 */

		/**
		 * Default configurations which will secure all the requests
		 */

		/*
		 * http .authorizeRequests() .anyRequest().authenticated() .and()
		 * .formLogin().and() .httpBasic();
		 */

		/**
		 * Custom configurations as per our requirement
		 */
		http.headers().frameOptions().disable();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/myAccount").authenticated().antMatchers("/myBalance").authenticated()
				.antMatchers("/myLoans").authenticated().antMatchers("/myCards").authenticated().antMatchers("/notices")
				.permitAll().antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();

		/**
		 * Configuration to deny all the requests
		 */

		/*
		 * http .authorizeRequests() .anyRequest().denyAll() .and() .formLogin() .and()
		 * .httpBasic();
		 */

		/**
		 * Configuration to permit all the requests
		 */

		/*
		 * http.authorizeRequests() .anyRequest().permitAll() .and(). formLogin() .and()
		 * .httpBasic();
		 */

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		UserDetails user = User.withUsername("admin").password("12345").authorities("admin").build();
		UserDetails user1 = User.withUsername("user").password("12345").authorities("user").build();
		userDetailsService.createUser(user);
		userDetailsService.createUser(user1);
		auth.userDetailsService(userDetailsService);
	}
}
