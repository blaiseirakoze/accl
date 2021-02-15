package com.volve.accl.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Advice {
	@Id
	private String id = UUID.randomUUID().toString();
	private String advice;
	private String attorneyId;
	private Date createOn;
	
	@ManyToOne
    @JoinColumn(name = "attorney")
    private Attorney attorney;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getAttorneyId() {
		return attorneyId;
	}

	public void setAttorneyId(String attorneyId) {
		this.attorneyId = attorneyId;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Attorney getAttorney() {
		return attorney;
	}

	public void setAttorney(Attorney attorney) {
		this.attorney = attorney;
	}

	@Override
	public String toString() {
		return "Advice [id=" + id + ", advice=" + advice + ", attorneyId=" + attorneyId + ", createOn=" + createOn
				+ ", attorney=" + attorney + "]";
	}
	
	
}
