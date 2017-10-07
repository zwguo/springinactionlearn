package org.springlearn03.withpara;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PerformTackerConfig.class)
public class PerformTackerConfigTest {

	@Autowired
	private PerformancePara performance;
	
	@Autowired
	private PerformTacker takcer;
	
	@Test
	public void test() {
		assertTrue(performance != null);
		performance.perform("a");
		performance.perform("b");
		performance.perform("a");
		performance.perform("b");
		performance.perform("d");
		performance.perform("c");
		
		Map<String, Integer> counts = takcer.getCounts();
		System.out.println(counts);
	}
}