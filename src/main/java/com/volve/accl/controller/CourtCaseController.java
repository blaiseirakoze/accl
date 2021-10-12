package com.volve.accl.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.volve.accl.pojo.CourtCaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
     * @param
     * @return
     */
    @RequestMapping(value = "/case", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<?> createCase(@RequestParam("document") MultipartFile document, @RequestParam String data) {
        try {
            return new ResponseEntity<GlobalResponse>(caseService.createCase(document, data), HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            throw new HandlerInternalServerErrorException("something went wrong! please try again");
        }
    }

    /**
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
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/caseStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCaseStatus(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String status) {
        try {
            return new ResponseEntity<GlobalResponse>(caseService.updateCaseStatus(id, status),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            throw new HandlerInternalServerErrorException("Server error");
        }
    }

}
