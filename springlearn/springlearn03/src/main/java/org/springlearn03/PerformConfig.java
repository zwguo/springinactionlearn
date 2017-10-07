package org.springlearn03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class PerformConfig {

	@Bean
	public AudienceWithPointCut audience() {
		return new AudienceWithPointCut();
	}
	
}
