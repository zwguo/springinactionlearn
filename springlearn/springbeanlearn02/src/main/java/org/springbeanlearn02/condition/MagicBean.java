package org.springbeanlearn02.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicBean {

	@Bean
	@Conditional(MagicConditional.class)
	public ConditionalBean getCb() {
		return new ConditionalBean();
	}
}
