package com.volve.accl.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Role {
	@Id
	private String id = UUID.randomUUID().toString();
	private String name;
	private Date createOn;
	
	@OneToMany(mappedBy = "role")
    private List<Users> user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", createOn=" + createOn + ", user=" + user + "]";
	}
	
	
}
