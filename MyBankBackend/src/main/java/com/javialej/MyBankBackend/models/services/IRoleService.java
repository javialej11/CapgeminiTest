package com.javialej.MyBankBackend.models.services;

import com.javialej.MyBankBackend.models.entity.Role;

public interface IRoleService {
	
	public Role findById(Long id);
	
	public Role findByName(String name);
	
}
