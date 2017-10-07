package org.springlearn03.around;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PerformConfig.class)
public class PerformConfigTest {

	@Autowired
	private Performance performance;
	
	@Test
	public void test() {
		assertTrue(performance != null);
		performance.perform();
	}
}
