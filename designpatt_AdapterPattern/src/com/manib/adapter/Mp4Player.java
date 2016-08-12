package com.manib.adapter;

public class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String fname) {
	}

	@Override
	public void playMp4(String fname) {
		System.out.println("playing mp4 file:" + fname);
	}

}
