package com.javialej.MyBankBackend.models.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javialej.MyBankBackend.models.dao.IRoleDAO;
import com.javialej.MyBankBackend.models.entity.Role;
import com.javialej.MyBankBackend.models.services.IRoleService;

@Service
public class RoleService implements IRoleService{
		
	@Autowired
	private IRoleDAO roleDAO;

	@Override
	@Transactional(readOnly = true)
	public Role findById(Long id) { 
		return roleDAO.findById(id).orElse(null);
	}
}