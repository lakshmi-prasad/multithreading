package com.manib.patterns;

public class AMDCPUFactory implements CPUFactory {

	@Override
	public CPU produceCPU() {
		return new AMDCPU();
	}

}
