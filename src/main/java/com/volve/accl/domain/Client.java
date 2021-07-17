package com.volve.accl.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client {
	@Id
	private String id = UUID.randomUUID().toString();
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private Date dob;
	private Date createOn= new Date();
	
	@OneToOne
    @JoinColumn(name = "Users")
    private Users users;
	
	@OneToMany(mappedBy = "client")
    private List<CourtCase> courtCase;

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

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", createOn=" + createOn + ", users=" + users
				+ ", courtCase=" + courtCase + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getAddress()=" + getAddress() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getDob()=" + getDob() + ", getCreateOn()=" + getCreateOn() + ", getUsers()="
				+ getUsers() + ", getCourtCase()=" + getCourtCase() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
