package com.manib.builder;

//director to encapsulate the builder
class Waiter {
	private StarbucksBuilder starbucksBuilder;

	public void setStarbucksBuilder(StarbucksBuilder builder) {
		starbucksBuilder = builder;
	}

	public Starbucks getstarbucksDrink() {
		return starbucksBuilder.getStarbucks();
	}

	public void constructStarbucks(String drink, String size) {
		starbucksBuilder.createStarbucks();
		starbucksBuilder.buildDrink(drink);
		starbucksBuilder.buildSize(size);
	}
}
