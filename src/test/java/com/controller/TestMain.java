package com.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("slk");
		String encoded=new BCryptPasswordEncoder().encode("password");
		System.out.println(encoded);
	}
	
}
