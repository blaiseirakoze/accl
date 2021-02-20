package com.volve.accl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volve.accl.domain.Role;

public interface RoleInterface extends JpaRepository<Role, String> {
	public Role findByName(String name);
}
