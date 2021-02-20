package com.volve.accl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volve.accl.domain.Role;
import com.volve.accl.repository.RoleInterface;

@Service
public class RoleService {
	
	@Autowired
	private RoleInterface roleInterface;
	
	public Role createRole(Role role) throws Exception {
		Role rolee = roleInterface.save(role);
		return rolee;
	}
}
