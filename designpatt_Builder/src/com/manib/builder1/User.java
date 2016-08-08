package com.manib.builder1;

public class User {

	private final String firstName;
	private final String lastName;
	private final int age;
	private final String phoneNumber;
	private final String address;
	
	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phoneNumber = builder.phoneNumber;
		this.address = builder.address;
	}
	
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }
	public int getAge() { return this.age; }
	public String phoneNumber() { return this.phoneNumber; }
	public String address() { return this.address; }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName + " ");
		sb.append(lastName + "; ");
		sb.append(age + "; ");
		sb.append(phoneNumber + "; ");
		sb.append(address + "; ");
		return sb.toString();
	}
	
	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private  int age;
		private  String phoneNumber;
		private  String address;
		
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder phone(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public User build() {
			User user = new User(this);
			if (user.age > 40) {
				throw new IllegalArgumentException("invalid age!");
			}
			return user;
		}
	}
}
