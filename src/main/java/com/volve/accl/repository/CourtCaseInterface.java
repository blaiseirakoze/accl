package com.volve.accl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volve.accl.domain.CourtCase;

public interface CourtCaseInterface extends JpaRepository<CourtCase, String> {

}
