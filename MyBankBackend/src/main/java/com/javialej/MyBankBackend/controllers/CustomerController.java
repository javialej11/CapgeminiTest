package com.javialej.MyBankBackend.controllers;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javialej.MyBankBackend.MyBankBackendApplication;
import com.javialej.MyBankBackend.models.entity.Customer;
import com.javialej.MyBankBackend.models.services.ICustomerService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping(MyBankBackendApplication.API+"/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/")
	public List<Customer> index(){
		return customerService.findAll();
	}
		
	// Necesita Pre-Authorize, Si hay error responder 403 Forbidden 
	
	@GetMapping("/{customerId}/get")
	public ResponseEntity<?> show(@PathVariable Long customerId){
		
		String message = "";
		Customer customer;
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			
			customer = customerService.findById(customerId);
			customer.setPassword("******");
			
		}catch(Exception e) {
			
			Instant instant = Instant.now();
			long timeStampMillis = instant.toEpochMilli();
			
			response.put("timestamp", timeStampMillis);
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			response.put("error", "Internal Server Error");
			response.put("exception", e.getStackTrace().toString());
			response.put("message", message);
			response.put("path", MyBankBackendApplication.API+"/customer/{customerId}/get");
			
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}					
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);	
		
			
	}

	@PostMapping("/sign-up")
	public ResponseEntity<?> create(@RequestBody Customer customer){

		String message = "";
		HashMap<String, Object> status = new HashMap<>();
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			customerService.save(customer);
			
			message = "Customer created successfully";
			
			status.put("status_code", HttpStatus.OK);
			status.put("status_desc", "SUCESS");
			
			response.put("status", status);
			response.put("response", message);
			
		}catch(Exception e) {
			
			Instant instant = Instant.now();
			long timeStampMillis = instant.toEpochMilli();
			
			response.put("timestamp", timeStampMillis);
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			response.put("error", "Internal Server Error");
			response.put("exception", e.getStackTrace().toString());
			response.put("message", message);
			response.put("path", MyBankBackendApplication.API+"/customer/sign-up");
			
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}					
		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);	
	}
}
