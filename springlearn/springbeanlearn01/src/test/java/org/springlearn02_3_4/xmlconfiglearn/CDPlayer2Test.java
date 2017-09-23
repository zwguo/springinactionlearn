package org.springlearn02_3_4.xmlconfiglearn;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springbeanlearn02.soundsystem.other.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/org/springlearn02_3_4/xmlconfiglearn/springapplication.xml"})
public class CDPlayer2Test {

	@Autowired
	private BlankDisc cd2;
	
	@Test
	public void cdPlayer2() {
		assertNotNull(cd2);
	}
}
