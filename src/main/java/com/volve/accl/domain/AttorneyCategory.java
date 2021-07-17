package com.volve.accl.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AttorneyCategory {
	@Id
	private String id = UUID.randomUUID().toString();
	private String name;
	private Date createOn = new Date();
	
	@OneToMany(mappedBy = "attorneyCategory")
	@JsonIgnore
    private List<Users> attorneys;
	
	public AttorneyCategory(String id, String name, Date createOn) {
		super();
		this.id = id;
		this.name = name;
		this.createOn = createOn;
	}

	public AttorneyCategory() {
		super();
	}



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

	public List<Users> getAttorneys() {
		return attorneys;
	}

	public void setAttorneys(List<Users> attorneys) {
		this.attorneys = attorneys;
	}

	@Override
	public String toString() {
		return "AttorneyCategory [id=" + id + ", name=" + name + ", createOn=" + createOn + ", attorneys=" + attorneys
				+ "]";
	}

}
