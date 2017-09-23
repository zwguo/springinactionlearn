package org.springbeanlearn02.soundsystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springbeanlearn02.soundsystem.CDPlayer;
import org.springbeanlearn02.soundsystem.CDPlayerConfig;
import org.springbeanlearn02.soundsystem.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;

/**
 * 简单验证自动注入
 * 
 * @author kwz
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

	@Autowired
	private CompactDisc cd;

	@Autowired(required=false)
	private CDPlayer cdplayer;

	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
	}

	@Test
	public void cdPlayerPlay() {
		assertNotNull(cdplayer);
		Assert.assertArrayEquals(new Object[]{cd}, new Object[]{cdplayer.getCD()});
	}
}
