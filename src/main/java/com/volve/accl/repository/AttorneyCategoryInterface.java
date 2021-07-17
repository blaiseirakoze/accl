package com.volve.accl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volve.accl.domain.AttorneyCategory;

public interface AttorneyCategoryInterface extends JpaRepository<AttorneyCategory, String> {
	public AttorneyCategory findByName(String name);
}
