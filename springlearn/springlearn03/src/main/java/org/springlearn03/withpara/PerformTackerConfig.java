package org.springlearn03.withpara;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class PerformTackerConfig {

	@Bean
	public PerformTacker getTacker() {
		return new PerformTacker();
	}
}
