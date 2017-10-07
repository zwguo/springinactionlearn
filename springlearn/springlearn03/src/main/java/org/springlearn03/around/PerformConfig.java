package org.springlearn03.around;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class PerformConfig {

	@Bean
	public AudienceAround audience() {
		return new AudienceAround();
	}
	
}
