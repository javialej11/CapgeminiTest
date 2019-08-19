package com.javialej.MyBankBackend.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javialej.MyBankBackend.models.entity.Customer;

@Repository
public interface ICustomerDAO extends CrudRepository<Customer, Long>{
	
	public Customer findByCustomerId(String customerId);

}
