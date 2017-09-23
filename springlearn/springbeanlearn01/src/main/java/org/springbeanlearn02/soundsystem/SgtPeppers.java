package org.springbeanlearn02.soundsystem;

import org.springframework.stereotype.Component;

@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
	
	public void play() {
		System.out.println("playing the title by artist.");
	}

}
