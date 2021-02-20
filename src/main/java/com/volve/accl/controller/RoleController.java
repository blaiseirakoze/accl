package com.volve.accl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.volve.accl.domain.Role;
import com.volve.accl.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/role", method = RequestMethod.POST)
	public ResponseEntity<?> createRole(@RequestBody Role role) throws Exception{
		Role rolee = roleService.createRole(role);
		return new ResponseEntity<Role>(rolee, HttpStatus.OK);
	}
}
