package org.springlearn02_3_3.javaconfiglearn;

import org.springbeanlearn02.soundsystem.CDPlayer;
import org.springbeanlearn02.soundsystem.CompactDisc;
import org.springbeanlearn02.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.springbeanlearn02.soundsystem")
public class CDPlayerConfig2 {
	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}
	
	@Bean
	public CDPlayer cdPlayer() {
		return new CDPlayer(sgtPeppers());
	}
}
