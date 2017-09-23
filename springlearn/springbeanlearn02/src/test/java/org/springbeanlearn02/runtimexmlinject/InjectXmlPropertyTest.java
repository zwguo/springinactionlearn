package org.springbeanlearn02.runtimexmlinject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/org/springbeanlearn02/runtimexmlinject/springapplication.xml"})
public class InjectXmlPropertyTest {

	@Autowired
	@Qualifier("annotation1")
	public InjectXmlPerson person1;
	
	@Autowired
	@Qualifier("xml1")
	public InjectXmlPerson person2;
	
	@Test
	public void test() {
		assertTrue(person1.toString().equals("123-中华人民共和国"));
		assertTrue(person2.toString().equals("123-中华人民共和国"));
	}

}
