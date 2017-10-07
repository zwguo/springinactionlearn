package org.springlearn03;

import static org.junit.Assert.assertTrue;

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
	
//  因为实现了接口故无法注入 Bean named 'woodstock' is expected to be of type 'org.springlearn03.Woodstock' but was actually of type 'com.sun.proxy.$Proxy24'
//	@Autowired
//	private Woodstock woodstock;
	
	@Test
	public void test() {
		assertTrue(performance != null);
		performance.perform();
//		assertTrue(woodstock != null);
//		woodstock.perform();
	}

}
