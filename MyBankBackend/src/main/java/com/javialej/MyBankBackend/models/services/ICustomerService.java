package com.javialej.MyBankBackend.models.services;

import java.util.List;

import com.javialej.MyBankBackend.models.entity.Customer;

public interface ICustomerService {
	
	public List<Customer> findAll();
	
	public Customer save(Customer customer);
	
	public Customer findById(Long id);
	
}
