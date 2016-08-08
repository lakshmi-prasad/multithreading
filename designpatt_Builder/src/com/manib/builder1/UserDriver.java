package com.manib.builder1;

public class UserDriver {

	public static void main(String[] args) {
		User user = new User.UserBuilder("Mani", "Bhushan")
							.age(33)
							.phone("610-242-9090")
							.address("earth")
							.build();
		System.out.println("final user object: ");
		System.out.println(user.toString());
	}
}
