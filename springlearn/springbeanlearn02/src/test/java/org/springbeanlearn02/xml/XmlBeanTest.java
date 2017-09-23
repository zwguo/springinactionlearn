package org.springbeanlearn02.xml;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/org/springbeanlearn02/xml/springapplication.xml"})
@ActiveProfiles("prod")
public class XmlBeanTest {
	@Autowired
	@Qualifier(value = "datasourcein")
	public InterfaceStringBean bean;

	@Test
	public void testActiveProfile() {
		assertTrue(bean.toString().equals("prod"));
	}
}
