package org.springlearn03.xml;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springlearn03.xml.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/org/springlearn03/xml/springapplicationwithpara.xml"})
public class AudienceWithParaTest {

	@Autowired
	public PerformancePara performance;
	
	@Autowired
	public PerformTacker tracker;
	
	@Test
	public void test() {
		assertTrue(performance != null);
		performance.perform("a");
		performance.perform("b");
		performance.perform("a");
		performance.perform("b");
		performance.perform("d");
		performance.perform("c");
		System.out.println(tracker.getCounts());
	}

}
