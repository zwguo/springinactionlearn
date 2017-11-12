package org.spring20.jmx.spring.jmx;

import java.io.IOException;

import org.junit.Test;
import org.spring20.jmx.spring.configuration.SpringJMXConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JMXBeanTest {

	/**
	 * jconsole test
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJMXConfiguration.class);
		JMXBean jmxBean = context.getBean(JMXBean.class);
		System.out.println("jmxBean:" + jmxBean);
		System.out.println("wait...");
		System.in.read();
	}

}
