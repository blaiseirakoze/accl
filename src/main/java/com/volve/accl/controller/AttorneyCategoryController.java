package com.volve.accl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.volve.accl.domain.AttorneyCategory;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.service.AttorneyCategoryService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AttorneyCategoryController {

	@Autowired
	private AttorneyCategoryService attorneyCategoryService;

	/**
	 * 
	 * @param AttorneyCategory
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/attorneyCategory", method = RequestMethod.POST)
	public ResponseEntity<?> createAttorneyCategory(@RequestBody AttorneyCategory AttorneyCategory,
			HttpServletRequest request) throws Exception {
		try {
			AttorneyCategory attorneyCategorye = attorneyCategoryService.createAttorneyCategory(AttorneyCategory,
					request);
			return new ResponseEntity<AttorneyCategory>(attorneyCategorye, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new Exception("Invalid credentials", e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/attorneyCategory", method = RequestMethod.GET)
	public ResponseEntity<?> listAttorneyCategory(){
		try {
			return new ResponseEntity<List<AttorneyCategory>>(attorneyCategoryService.listAttorneyCategory(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server error");
		}
	}
}
