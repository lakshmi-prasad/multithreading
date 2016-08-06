package com.manib.patterns;

public class Computer {
	CPU cpu;
	
	public Computer(CPUFactory cpuFactory) {
		cpu = cpuFactory.produceCPU();
		cpu.process();
	}
}
