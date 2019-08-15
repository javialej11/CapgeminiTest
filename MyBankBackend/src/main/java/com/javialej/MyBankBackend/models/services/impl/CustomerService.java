package com.javialej.MyBankBackend.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javialej.MyBankBackend.models.dao.ICustomerDAO;
import com.javialej.MyBankBackend.models.entity.Customer;
import com.javialej.MyBankBackend.models.services.ICustomerService;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return (List<Customer>) customerDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findById(Long id) { 
		return customerDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {
		return customerDAO.save(customer);
	}
	
	
}
