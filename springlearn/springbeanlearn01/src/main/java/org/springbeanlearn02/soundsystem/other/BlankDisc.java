package org.springbeanlearn02.soundsystem.other;

import org.springbeanlearn02.soundsystem.CompactDisc;

public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;

	public BlankDisc(String t, String a) {
		this.title = t;
		this.artist = a;
	}

	public void play() {
		System.out.println("playing the " + title + " by " + artist);
	}

}
