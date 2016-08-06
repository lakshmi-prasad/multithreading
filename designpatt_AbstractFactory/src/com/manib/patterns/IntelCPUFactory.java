package com.manib.patterns;

public class IntelCPUFactory implements CPUFactory {

	@Override
	public CPU produceCPU() {
		return new IntelCPU();
	}

}
