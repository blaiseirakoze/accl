package com.volve.accl.pojo;

import java.util.Date;

public class CourtCaseRequest {
    private String caseDescription;
    private String client;
    private String document;

    public CourtCaseRequest() {
    }

    public CourtCaseRequest(String caseDescription, String client, String document) {
        this.caseDescription = caseDescription;
        this.client = client;
        this.document = document;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "CourtCaseRequest{" +
                "caseDescription='" + caseDescription + '\'' +
                ", client='" + client + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
