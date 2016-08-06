package com.manib.patterns;

public class FactoryDriver {

	private Human human = null;
	
	public static void main(String[] args) {
		FactoryDriver fd = new FactoryDriver();
		String [] input = {"boy", "girl" };
		fd.generateHumans(input );
	}
	
	public void generateHumans(String [] input) {
		for (int i=0; i<input.length; i++) {
			if (input[i].equals("boy")) {
				human = new Boy();
			} else if (input[i].equals("girl")) {
				human = new Girl();
			}
			human.walk();
			human.talk();
		}
	}
}
