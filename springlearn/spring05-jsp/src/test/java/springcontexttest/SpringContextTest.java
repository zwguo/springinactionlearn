package springcontexttest;

import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

public class SpringContextTest {

	@Test
	public void testContext() {
		String configXml = "springapplication.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(configXml);
		HandlerMapping hmapping = ac.getBean(SimpleUrlHandlerMapping.class);
		Properties urlMappings = ac.getBean("urlMappings", Properties.class);
		assertNotNull(hmapping);
		assertNotNull(urlMappings);
	}
}
