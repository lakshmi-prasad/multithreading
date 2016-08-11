package com.manib.spring;

public class Person {
	
	public Person() {}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}

	private int id;
	private String name;
	private Address address;

	public void setAddress(Address address) {
		this.address = address;
	}

	public void speak() {
		System.out.println("person is speaking... :)");
	}
}
