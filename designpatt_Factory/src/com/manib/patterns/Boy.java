package com.manib.patterns;

public class Boy implements Human {

	@Override
	public void talk() {
		System.out.println("Boy Talking!");
	}

	@Override
	public void walk() {
		System.out.println("Boy Waling!");
	}

}
