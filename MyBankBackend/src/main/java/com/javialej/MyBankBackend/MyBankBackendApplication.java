package com.javialej.MyBankBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBankBackendApplication {

	public final static String API = "/api/1.0";
	
	public static void main(String[] args) {
		SpringApplication.run(MyBankBackendApplication.class, args);
	}

}
