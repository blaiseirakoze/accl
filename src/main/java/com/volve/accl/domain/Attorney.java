package com.volve.accl.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Attorney {
	@Id
	private String id = UUID.randomUUID().toString();
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private Date dob;
	private String attorneyCategoryId;
	private String document;
	private Date createOn;
	
	@OneToOne
    @JoinColumn(name = "Users")
    private Users users;
	
	@OneToMany(mappedBy = "attorney")
    private List<CourtCase> courtCase;
	
	@ManyToOne
    @JoinColumn(name = "attorneyCategory")
    private AttorneyCategory attorneyCategory;
	
	@OneToMany(mappedBy = "attorney")
    private List<Advice> advice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAttorneyCategoryId() {
		return attorneyCategoryId;
	}

	public void setAttorneyCategoryId(String attorneyCategoryId) {
		this.attorneyCategoryId = attorneyCategoryId;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<CourtCase> getCourtCase() {
		return courtCase;
	}

	public void setCourtCase(List<CourtCase> courtCase) {
		this.courtCase = courtCase;
	}

	public AttorneyCategory getAttorneyCategory() {
		return attorneyCategory;
	}

	public void setAttorneyCategory(AttorneyCategory attorneyCategory) {
		this.attorneyCategory = attorneyCategory;
	}

	public List<Advice> getAdvice() {
		return advice;
	}

	public void setAdvice(List<Advice> advice) {
		this.advice = advice;
	}

	
	
	
}
