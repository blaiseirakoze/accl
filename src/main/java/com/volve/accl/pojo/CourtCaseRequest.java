package com.volve.accl.pojo;

import java.util.Date;

public class CourtCaseRequest {
    private String caseDescription;
    private String client;
    private String attorney;

    public CourtCaseRequest() {
    }

    public CourtCaseRequest(String caseDescription, String client, String attorney) {
        this.caseDescription = caseDescription;
        this.client = client;
        this.attorney = attorney;
    }

    public String getAttorney() {
        return attorney;
    }

    public void setAttorney(String attorney) {
        this.attorney = attorney;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "CourtCaseRequest{" +
                "caseDescription='" + caseDescription + '\'' +
                ", client='" + client + '\'' +
                ", attorney='" + attorney + '\'' +
                '}';
    }
}
