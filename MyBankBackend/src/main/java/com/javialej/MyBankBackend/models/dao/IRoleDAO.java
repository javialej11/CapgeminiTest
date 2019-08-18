package com.javialej.MyBankBackend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.javialej.MyBankBackend.models.entity.Role;

public interface IRoleDAO extends CrudRepository<Role, Long>{
	
	public Role findById(String id);

}
