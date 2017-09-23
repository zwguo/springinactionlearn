package org.springbeanlearn02.runtimeinject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/org/springbeanlearn02/runtimeinject/app.properties")
public class InjectProperty {

	@Autowired
	private Environment env;

	@Bean
	public InjectPerson getPerson() {
		return new InjectPerson(env.getProperty("id", Integer.class), env.getProperty("name", "defaultname"));
	}
}
