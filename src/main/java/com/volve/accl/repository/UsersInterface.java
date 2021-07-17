package com.volve.accl.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.volve.accl.domain.Users;

public interface UsersInterface extends JpaRepository<Users, String> {
	public Users findByUsername(String username);
}
