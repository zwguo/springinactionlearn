package org.springbeanlearn02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileBean.class)
@ActiveProfiles("prod")
public class ProfileBeanTest {

	@Autowired
	@Qualifier(value = "dsname")
	public String dsName;
	
	@Autowired
	@Qualifier(value = "otherthing")
	public String otherthing;

	@Test
	public void testActiveProfile() {
		System.out.println(otherthing);
		assertTrue(dsName == "prod");
	}
}
