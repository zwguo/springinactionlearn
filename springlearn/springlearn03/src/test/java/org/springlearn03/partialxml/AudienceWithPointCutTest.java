package org.springlearn03.partialxml;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/org/springlearn03/partialxml/springapplication.xml"})
public class AudienceWithPointCutTest {

	@Autowired
	public Performance performance;
	
	@Test
	public void test() {
		assertTrue(performance != null);
		performance.perform();
	}

}
