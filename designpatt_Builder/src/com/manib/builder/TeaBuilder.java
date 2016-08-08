package com.manib.builder;

//Concrete Builder to build tea
class TeaBuilder extends StarbucksBuilder {

	public void buildSize(String size) {
		starbucks.setSize(size);
		System.out.println("drink size: " + size);
	}

	public void buildDrink(String drink) {
		starbucks.setDrink(drink);
		System.out.println("drink type: " + drink);
	}
}

