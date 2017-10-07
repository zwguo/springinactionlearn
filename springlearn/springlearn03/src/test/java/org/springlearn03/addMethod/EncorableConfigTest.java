package org.springlearn03.addMethod;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=EncorableConfig.class)
public class EncorableConfigTest {

//	@Autowired
//	public EncoreableIntroducer introducer;
	
//	@Autowired
//	public Encoreable encorable;
	
	@Autowired
	public Performance performance;
	
	@Test
	public void test() {
		//assertTrue(introducer != null);
		//assertTrue(encorable != null);
		assertTrue(performance != null);
		assertTrue((Encoreable)performance != null);
		performance.perform();
		((Encoreable)performance).performEncore();
	}

}
