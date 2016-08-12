package com.manib.spring;

public class Address {

	private String street;
	private String postcode;
	
	public Address() {}
	
	public Address(String street, String postcode) {
		this.street = street;
		this.postcode = postcode;
	}
	
	public void init() {
		System.out.println("address init!" + this);
	}
	
	
	public void destroy() {
		System.out.println("address destroyed!!");
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + "]";
	}
	
	
}
