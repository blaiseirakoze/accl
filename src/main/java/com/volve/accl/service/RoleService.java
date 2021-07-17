package com.volve.accl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volve.accl.domain.Role;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.exception.HandlerNotFoundException;
import com.volve.accl.repository.RoleInterface;

@Service
public class RoleService {

	@Autowired
	private RoleInterface roleInterface;

	/**
	 * 
	 * @param role
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Role createRole(Role role, HttpServletRequest request) throws Exception {
		try {
			Role foundRole = roleInterface.findByName(role.getName());
			if (foundRole != null) {
				throw new HandlerNotFoundException("Role already exist");
			}
			return roleInterface.save(role);
		} catch (Exception e) {
			throw new Exception("Invalid credentials", e);
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<Role> listRole() {
		try {
			return roleInterface.findAll();
		} catch (Exception e) {
			throw new HandlerInternalServerErrorException("Server error");
		}
	}
}
