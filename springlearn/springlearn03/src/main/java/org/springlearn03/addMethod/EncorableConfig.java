package org.springlearn03.addMethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class EncorableConfig {
	
	/**
	 * 必须要定义切面 bean
	 * @return
	 */
	@Bean
	public EncoreableIntroducer getIntroducer() {
		return new EncoreableIntroducer();
	}
}
