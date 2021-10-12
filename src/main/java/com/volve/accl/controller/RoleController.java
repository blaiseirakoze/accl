package com.volve.accl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.volve.accl.domain.Role;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.service.RoleService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * 
	 * @param role
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public ResponseEntity<?> createRole(@RequestBody Role role, HttpServletRequest request) throws Exception {
		try {
			Role rolee = roleService.createRole(role, request);
			return new ResponseEntity<Role>(rolee, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("Invalid credentials", e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public ResponseEntity<?> listRole(){
		try {
			return new ResponseEntity<List<Role>>(roleService.listRole(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server error");
		}
	}
}
