package com.manib.builder;

//customer
public class Customer {
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		StarbucksBuilder coffeeBuilder = new CoffeeBuilder();

		//Alternatively you can use tea builder to build a tea
		//StarbucksBuilder teaBuilder = new TeaBuilder();

		waiter.setStarbucksBuilder(coffeeBuilder);
		
		String drink = "Coffee";
		String size = "Large";
		waiter.constructStarbucks(drink, size);

		//get the drink built
		Starbucks sb = waiter.getstarbucksDrink();
		System.out.println(sb.toString());

	}
}
