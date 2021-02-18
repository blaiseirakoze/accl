package com.volve.accl.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Users {
	@Id
	private String id = UUID.randomUUID().toString();
	private String username;
	private String password;
	private String roleId;
	private String userId;
	private Date createOn;
	
	@OneToOne(mappedBy = "users")
    private Client client;
	
	@OneToOne(mappedBy = "users")
    private Attorney attorney;

	@ManyToOne
    @JoinColumn(name = "role")
    private Role role;

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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roleId=" + roleId
				+ ", userId=" + userId + ", createOn=" + createOn + ", client=" + client + ", attorney=" + attorney
				+ ", role=" + role + "]";
	}
	
	
}
