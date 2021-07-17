package com.volve.accl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.volve.accl.domain.CourtCase;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.pojo.GlobalResponse;
import com.volve.accl.service.CourtCaseService;

@RestController
@RequestMapping("/api")
public class CourtCaseController {

	@Autowired
	private CourtCaseService caseService;

	/**
	 * 
	 * @param courtCase
	 * @return
	 */
	@RequestMapping(value = "/case", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> createCase(@RequestBody CourtCase courtCase) {
		try {
			return new ResponseEntity<String>(caseService.createCase(courtCase), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/case", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> listCases() {
		try {
			return new ResponseEntity<List<CourtCase>>(caseService.listCases(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

	/**
	 * 
	 * @param id
	 * @param status
	 * @param caseSummary
	 * @param won
	 * @return
	 */
	@RequestMapping(value = "/caseStatus", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> updateCaseStatus(@RequestParam String id, String status, String caseSummary, boolean won) {
		try {
			return new ResponseEntity<GlobalResponse>(caseService.updateCaseStatus(id, status, caseSummary, won),
					HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

}
