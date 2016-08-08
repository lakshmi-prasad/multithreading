package com.manib.builder;

public abstract class StarbucksBuilder {

	protected  Starbucks starbucks;
	
	
	public Starbucks getStarbucks() { return this.starbucks; }
	
	public void createStarbucks() {
		this.starbucks = new Starbucks();
	}
	
	public abstract void buildSize(String size);
	public abstract void buildDrink(String drink);
}
