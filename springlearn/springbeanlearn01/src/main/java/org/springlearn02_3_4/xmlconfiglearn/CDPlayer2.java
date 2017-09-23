package org.springlearn02_3_4.xmlconfiglearn;

import org.springbeanlearn02.soundsystem.CompactDisc;
import org.springbeanlearn02.soundsystem.MediaPlayer;

public class CDPlayer2 implements MediaPlayer {

	private CompactDisc cd;

	public CDPlayer2(CompactDisc cd) {
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}

	public CompactDisc getCD() {
		return cd;
	}
}