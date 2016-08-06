package com.manib.patterns;

import java.util.Random;

/*
Abstract Factory pattern adds another layer of abstraction for Factory pattern. 
If we compare Abstract Factory with Factory, it is pretty obvious that a new layer of 
abstraction is added. Abstract Factory is a super-factory which creates other factories. 
We can call it "Factory of factories".
*/

public class AbstractFactoryDriver {
	
	private CPUFactory factory = null;
	
	public static void main(String[] args) {
		AbstractFactoryDriver afd = new AbstractFactoryDriver();
		afd.createComputers();
	}
	
	public void createComputers() {
		Random rand = new Random();
		
		for (int i=0; i<10; i++) {
			if (rand.nextInt(1000)%2 == 0) { //product intel CPU computers when even, otherwise AMD
				factory = new IntelCPUFactory();
				new Computer(factory);
			} else {
				factory = new AMDCPUFactory();
				new Computer(factory);
			}
		}
	}
}
