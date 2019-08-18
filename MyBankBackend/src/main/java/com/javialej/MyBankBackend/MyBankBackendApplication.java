package com.javialej.MyBankBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MyBankBackendApplication implements CommandLineRunner{

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	public final static String API = "/api/1.0";
	
	public static void main(String[] args) {
		SpringApplication.run(MyBankBackendApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {
		String password = "javialej";
		
		String encrypted = passwordEncoder.encode(password);
		System.out.println(encrypted);
	}

}
