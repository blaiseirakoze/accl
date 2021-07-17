package com.volve.accl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volve.accl.domain.AttorneyCategory;
import com.volve.accl.exception.HandlerConflictException;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.repository.AttorneyCategoryInterface;

@Service
public class AttorneyCategoryService {

	@Autowired
	private AttorneyCategoryInterface attorneyCategoryInterface;

	/**
	 * 
	 * @param AttorneyCategory
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public AttorneyCategory createAttorneyCategory(AttorneyCategory AttorneyCategory, HttpServletRequest request)
			throws Exception {
		try {
			AttorneyCategory foundAttorneyCategory = attorneyCategoryInterface.findByName(AttorneyCategory.getName());
			if (foundAttorneyCategory != null) {
				throw new HandlerConflictException("AttorneyCategory already exist");
			}
			return attorneyCategoryInterface.save(AttorneyCategory);
		} catch (Exception e) {
			throw new Exception("Invalid credentials", e);
		}

	}

	/**
	 * 
	 * @return
	 */
	public List<AttorneyCategory> listAttorneyCategory() {
		try {
			return attorneyCategoryInterface.findAll();
		} catch (Exception e) {
			throw new HandlerInternalServerErrorException("Server error");
		}
	}
}
