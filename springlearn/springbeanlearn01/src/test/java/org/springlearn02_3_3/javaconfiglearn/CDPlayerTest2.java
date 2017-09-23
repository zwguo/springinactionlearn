package org.springlearn02_3_3.javaconfiglearn;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springbeanlearn02.soundsystem.CDPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig2.class)
public class CDPlayerTest2 {

	@Autowired(required=false)
	private CDPlayer cdplayer;
	
	@Test
	public void cdPlayerPlay() {
		assertNotNull(cdplayer);
	}
}
