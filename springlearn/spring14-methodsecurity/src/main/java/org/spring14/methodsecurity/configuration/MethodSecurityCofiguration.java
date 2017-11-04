package org.spring14.methodsecurity.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
//use jsr
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@ComponentScan("org.spring14.methodsecurity")
public class MethodSecurityCofiguration extends GlobalMethodSecurityConfiguration {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("password1").roles("USER");
	}

	
}
