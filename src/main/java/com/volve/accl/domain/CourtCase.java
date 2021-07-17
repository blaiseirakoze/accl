package com.volve.accl.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CourtCase {
	@Id
	private String id = UUID.randomUUID().toString();
	private String caseDescription;
	private String status; //open, accept, deny, close
	private boolean won = false;
	private String caseSummary;
	private String document;
	private boolean deleted = false;
	private Date createOn = new Date();
	private Date updatedOn= new Date();
	
	@ManyToOne
    @JoinColumn(name = "client")
    private Users client;
	
	@ManyToOne
    @JoinColumn(name = "attorney")
    private Users attorney;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCaseDescription() {
		return caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public String getCaseSummary() {
		return caseSummary;
	}

	public void setCaseSummary(String caseSummary) {
		this.caseSummary = caseSummary;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Users getClient() {
		return client;
	}

	public void setClient(Users client) {
		this.client = client;
	}

	public Users getAttorney() {
		return attorney;
	}

	public void setAttorney(Users attorney) {
		this.attorney = attorney;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CourtCase [id=" + id + ", caseDescription=" + caseDescription + ", status=" + status + ", won=" + won
				+ ", caseSummary=" + caseSummary + ", document=" + document + ", deleted=" + deleted + ", createOn="
				+ createOn + ", updatedOn=" + updatedOn + ", client=" + client + ", attorney=" + attorney + "]";
	}

}
