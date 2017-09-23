package org.springbeanlearn02.condition;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MagicBean.class)
@ActiveProfiles("testcondition")
public class MagicBeanTest {

	@Autowired(required=false)
	public ConditionalBean bean;
	
	@Test
	public void testCreated() {
		assertTrue(bean != null);
	}
}
