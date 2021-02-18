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
	private boolean accepted = false;
	private boolean won = false;
	private String caseSummary;
	private String clientId;
	private String attorneyId;
	private boolean deleted = false;
	private Date createOn;
	
	@ManyToOne
    @JoinColumn(name = "client")
    private Client client;
	
	@ManyToOne
    @JoinColumn(name = "attorney")
    private Attorney attorney;

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

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAttorneyId() {
		return attorneyId;
	}

	public void setAttorneyId(String attorneyId) {
		this.attorneyId = attorneyId;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Attorney getAttorney() {
		return attorney;
	}

	public void setAttorney(Attorney attorney) {
		this.attorney = attorney;
	}

	@Override
	public String toString() {
		return "CourtCase [id=" + id + ", caseDescription=" + caseDescription + ", accepted=" + accepted + ", won="
				+ won + ", caseSummary=" + caseSummary + ", clientId=" + clientId + ", attorneyId=" + attorneyId
				+ ", deleted=" + deleted + ", createOn=" + createOn + ", client=" + client + ", attorney=" + attorney
				+ "]";
	}
	
	
}
