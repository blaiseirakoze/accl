package com.volve.accl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.volve.accl.domain.Client;
import com.volve.accl.domain.Role;
import com.volve.accl.domain.Users;
import com.volve.accl.payload.ClientRequest;
import com.volve.accl.repository.ClientInterface;
import com.volve.accl.repository.RoleInterface;
import com.volve.accl.repository.UsersInterface;

@Service
public class ClientService {
	
	@Autowired
	private ClientInterface clientInterface;
	
	@Autowired
	private UsersInterface usersInterface;
	
	@Autowired
	private RoleInterface roleInterface;
	
	@Autowired
    PasswordEncoder encoder;
	
	public Users createClient(ClientRequest clientRequest) throws Exception  {
		
//		find role by name
		Role role = roleInterface.findByName("client");
		
//		save user
		Users users = new Users();
		users.setActive(true);
		users.setRole(role);
		users.setUsername(clientRequest.getUsername());
		users.setPassword(encoder.encode(clientRequest.getPassword()));
		Users usersRes = usersInterface.save(users);
		
//		save client
		Client client = new Client();
		client.setAddress(clientRequest.getAddress());
		client.setDob(clientRequest.getDob());
		client.setFirstName(clientRequest.getFirstName());
		client.setLastName(clientRequest.getLastName());
		client.setPhoneNumber(clientRequest.getPhoneNumber());
		client.setUsers(usersRes);
		clientInterface.save(client);
		
		return usersRes;
	}

}
