package com.javialej.MyBankBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MyBankBackendApplication implements CommandLineRunner{

	public final static String API = "/api/1.0";
	
	public static void main(String[] args) {
		SpringApplication.run(MyBankBackendApplication.class, args);
	}
	
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void run(String...args) throws Exception {
		
		// Routine created for BCryptPassword
		// String password = "javialej";
		// String encrypted = passwordEncoder.encode(password);
		// System.out.println(encrypted);
	}

}
