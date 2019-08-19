package com.javialej.MyBankBackend.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javialej.MyBankBackend.models.entity.Role;

@Repository
public interface IRoleDAO extends CrudRepository<Role, Long>{
	
	public Role findById(String id);
	public Role findByName(String name);

}
