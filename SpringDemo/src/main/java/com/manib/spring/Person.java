package com.manib.spring;

public class Person {
	
	public Person() {}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void onCreate() {
		System.out.println("Person Created: " + this);
	}
	
	public void onDestroy() {
		System.out.println("person destroyed!");
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId
				+ ", address=" + address + "]";
	}

	private int id;
	private String name;
	private int taxId;
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	private Address address;

	public void setAddress(Address address) {
		this.address = address;
	}

	public void speak() {
		System.out.println("person is speaking... :)");
	}
}
