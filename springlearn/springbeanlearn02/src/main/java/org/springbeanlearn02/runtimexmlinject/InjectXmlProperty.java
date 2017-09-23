package org.springbeanlearn02.runtimexmlinject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InjectXmlProperty {

	@Bean("annotation1")
	public InjectXmlPerson getPerson(@Value("${id}") Integer id, @Value("${name}") String name) {
		return new InjectXmlPerson(id, name);
	}
}
