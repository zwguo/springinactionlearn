package org.springlearn03.xml;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springlearn03.xml.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/org/springlearn03/xml/springapplicationwithpointcut.xml"})
public class AudienceWithPointCutTest {

	@Autowired
	public Performance performance;
	
	@Test
	public void test() {
		assertTrue(performance != null);
		performance.perform();
	}

}
