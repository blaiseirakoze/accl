package com.volve.accl.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AttorneyCategory {
	@Id
	private String id = UUID.randomUUID().toString();
	private String name;
	private Date createOn;
	
	@OneToMany(mappedBy = "attorneyCategory")
    private List<Attorney> attorney;

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

	public List<Attorney> getAttorney() {
		return attorney;
	}

	public void setAttorney(List<Attorney> attorney) {
		this.attorney = attorney;
	}

	@Override
	public String toString() {
		return "AttorneyCategory [id=" + id + ", name=" + name + ", createOn=" + createOn + ", attorney=" + attorney
				+ "]";
	}
	
	
}
