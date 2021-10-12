package com.volve.accl.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.volve.accl.pojo.CourtCaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.volve.accl.domain.CourtCase;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.pojo.GlobalResponse;
import com.volve.accl.service.CourtCaseService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CourtCaseController {

	@Autowired
	private CourtCaseService caseService;

	/**
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/case", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ResponseEntity<?> createCase(@RequestParam("caseData") MultipartFile caseData, @RequestParam("caseDocument") MultipartFile caseDocument) {
		CourtCase courtCase = new Gson().fromJson((JsonElement) caseData,CourtCase.class);

		System.out.println("courtCaseeeeeeeeeeeeeeeeeeeeeeeeee "+ caseDocument);
		System.out.println("clienttttttttttttttttttttttttttttt "+ courtCase);
		try {
//			return new ResponseEntity<String>(caseService.createCase(courtCase), HttpStatus.CREATED);
			return null;
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
