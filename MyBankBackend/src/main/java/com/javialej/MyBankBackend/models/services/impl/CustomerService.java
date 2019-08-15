package com.javialej.MyBankBackend.models.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javialej.MyBankBackend.models.dao.ICustomerDAO;
import com.javialej.MyBankBackend.models.entity.Customer;
import com.javialej.MyBankBackend.models.services.ICustomerService;

@Service
public class CustomerService implements ICustomerService, UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
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

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String customerId) throws UsernameNotFoundException {
		
		Customer customer = customerDAO.findByCustomerId(customerId);
		
		if(customer == null) {
			String msg = "Error in login: the customer_id "+ customerId +" doesn't exists in the system";
			logger.error(msg);
			throw new UsernameNotFoundException(msg);
		}
		
		List<GrantedAuthority> authorities = customer.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(customer.getCustomerId(), customer.getPassword(), customer.getEnabled(), true, true, true, authorities);
	}
		
}
