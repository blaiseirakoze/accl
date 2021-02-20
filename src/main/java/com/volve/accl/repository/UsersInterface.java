package com.volve.accl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volve.accl.domain.Users;

public interface UsersInterface extends JpaRepository<Users, String> {

	Optional<Users> findByUsername(String username);
}
