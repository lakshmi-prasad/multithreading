package com.manib.builder;


//Concrete builder to build coffee
class CoffeeBuilder extends StarbucksBuilder {
	public void buildSize(String size) {
		starbucks.setSize(size);
		System.out.println("drink size: " + size);
	}

	public void buildDrink(String drink) {
		starbucks.setDrink(drink);
		System.out.println("drink type: " + drink);
	}
}
