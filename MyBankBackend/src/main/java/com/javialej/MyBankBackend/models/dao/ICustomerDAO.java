package com.javialej.MyBankBackend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.javialej.MyBankBackend.models.entity.Customer;

public interface ICustomerDAO extends CrudRepository<Customer, Long>{
	
	public Customer findByCustomerId(String customerId);

}
