package org.spring09.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/**
	 * 配置用户存储
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//roles和authorities一样，不会回自动在角色前加上ROLE_
		auth.inMemoryAuthentication().withUser("user").password("123").roles("USER")
		.and()
		.withUser("user1").password("123").roles("USER2");
	}

	/**
	 * 配置哪些需要访问
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/security").hasRole("USER2");
		http.authorizeRequests().antMatchers("/me/**").authenticated().and().formLogin().and().httpBasic();
		http.authorizeRequests().anyRequest().permitAll();
		http.logout().logoutSuccessUrl("/hello/index").logoutUrl("/signout");
	}
	
	
}
