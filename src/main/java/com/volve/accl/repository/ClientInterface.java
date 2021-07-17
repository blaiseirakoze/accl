package com.volve.accl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volve.accl.domain.Client;
import com.volve.accl.domain.Role;

public interface ClientInterface extends JpaRepository<Client, String>  {
	
}
