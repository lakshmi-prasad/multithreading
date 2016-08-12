package com.manib.adapter;

public class VLCPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String fname) {
		System.out.println("playing vlc file: " + fname);
	}

	@Override
	public void playMp4(String fname) {
		//do nothing.
	}

}
