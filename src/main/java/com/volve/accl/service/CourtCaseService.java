package com.volve.accl.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.volve.accl.domain.CourtCase;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.exception.HandlerNotFoundException;
import com.volve.accl.pojo.GlobalResponse;
import com.volve.accl.repository.CourtCaseInterface;

@Service
public class CourtCaseService {

	@Autowired
	private CourtCaseInterface caseInterface;

	/**
	 * 
	 * @param courtCase
	 * @return
	 */
	public String createCase(CourtCase courtCase) {
		try {
			caseInterface.save(courtCase);
			return "Case successfully created";
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<CourtCase> listCases() {
		try {
			return caseInterface.findAll();
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
	public GlobalResponse updateCaseStatus(String id, String status, String caseSummary, boolean won) {
		try {
			CourtCase founCourtCase = caseInterface.findById(id).orElse(new CourtCase());
			if (founCourtCase == null) {
				throw new HandlerNotFoundException("Case not found");
			}
			if (status.equals("close")) {
				founCourtCase.setCaseSummary(caseSummary);
				founCourtCase.setWon(won);
			}
			founCourtCase.setStatus(status);
			founCourtCase.setUpdatedOn(new Date());
			caseInterface.save(founCourtCase);
			return new GlobalResponse(HttpStatus.CREATED.toString(), "Status changed");
		} catch (Exception e) {
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

}
