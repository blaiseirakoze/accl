package com.volve.accl.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
	@Id
	private String id = UUID.randomUUID().toString();
	private String username;
	private String password;
	private Boolean active=true;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private Date dob;
	private String document;
	private Date createOn = new Date();
	private int rate = 0;
	@Transient
	private String userRole;
	@Transient
	private String userAttorneyCategory;
	
	@ManyToOne
    @JoinColumn(name = "role")
    private Role role;
	
	@OneToMany(mappedBy = "client")
    private List<CourtCase> clientCourtCase;
	
	@OneToMany(mappedBy = "attorney")
    private List<CourtCase> attorneyCourtCase;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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


	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserAttorneyCategory() {
		return userAttorneyCategory;
	}

	public void setUserAttorneyCategory(String userAttorneyCategory) {
		this.userAttorneyCategory = userAttorneyCategory;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public List<CourtCase> getClientCourtCase() {
		return clientCourtCase;
	}

	public void setClientCourtCase(List<CourtCase> clientCourtCase) {
		this.clientCourtCase = clientCourtCase;
	}

	public List<CourtCase> getAttorneyCourtCase() {
		return attorneyCourtCase;
	}

	public void setAttorneyCourtCase(List<CourtCase> attorneyCourtCase) {
		this.attorneyCourtCase = attorneyCourtCase;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", active=" + active
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", dob=" + dob + ", document=" + document + ", createOn=" + createOn + ", rate=" + rate
				+ ", userRole=" + userRole + ", userAttorneyCategory=" + userAttorneyCategory + ", role=" + role
				+ ", clientCourtCase=" + clientCourtCase + ", attorneyCourtCase=" + attorneyCourtCase
				+ ", attorneyCategory=" + attorneyCategory + ", advice=" + advice + "]";
	}

}
