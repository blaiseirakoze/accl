package com.volve.accl.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.volve.accl.domain.Users;
import com.volve.accl.pojo.CourtCaseRequest;
import com.volve.accl.repository.UsersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.volve.accl.domain.CourtCase;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.exception.HandlerNotFoundException;
import com.volve.accl.pojo.GlobalResponse;
import com.volve.accl.repository.CourtCaseInterface;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CourtCaseService {

    @Autowired
    private CourtCaseInterface caseInterface;

    @Autowired
    UsersInterface usersInterface;

    private String basePath = "/home/irakoze/Documents/my-own/accl-project/files/";

    /**
     * @param document
     * @param data
     * @return
     */
    public GlobalResponse createCase(MultipartFile document, @RequestParam String data) {
        try {
            //pass to case data to court case object
            CourtCaseRequest courtCaseRequest = new Gson().fromJson(data, CourtCaseRequest.class);
            //check if client exist
            Users foundUser = usersInterface.findById(courtCaseRequest.getClient()).orElse(new Users());
            if (foundUser == null) {
                throw new HandlerNotFoundException("Client not found");
            }
            //check if attorney exist
            Users foundAttorney = usersInterface.findById(courtCaseRequest.getAttorney()).orElse(new Users());
            if (foundAttorney == null) {
                throw new HandlerNotFoundException("Attorney not found");
            }
            // document name format
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String fileName = simpleDateFormat.format(new Date()) + "-" + document.getOriginalFilename().replace(" ", "-");
            Path path = Paths.get(basePath + fileName);
            // create case
            CourtCase courtCaseToSave = new CourtCase(courtCaseRequest.getCaseDescription(), path.toString(), foundUser);
            courtCaseToSave.setAttorney(foundAttorney);
            CourtCase courtCase = caseInterface.save(courtCaseToSave);
            if (courtCase != null) {
                // move a document to a specific folder
                Files.write(path, document.getBytes());
                return new GlobalResponse(HttpStatus.CREATED.toString(), "case successfully created");
            }
            throw new HandlerInternalServerErrorException("Server error");
        } catch (Exception e) {
            // TODO: handle exception
            throw new HandlerInternalServerErrorException("Server error");
        }
    }

    /**
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
     * @param id
     * @param status
     * @return
     */
    public GlobalResponse updateCaseStatus(String id, String status) {
        try {
            CourtCase founCourtCase = caseInterface.findById(id).orElse(new CourtCase());
            if (founCourtCase == null) {
                throw new HandlerNotFoundException("Case not found");
            }
            founCourtCase.setStatus(status);
            caseInterface.save(founCourtCase);
            return new GlobalResponse(HttpStatus.CREATED.toString(), "Status changed");
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Server error");
        }
    }

}
