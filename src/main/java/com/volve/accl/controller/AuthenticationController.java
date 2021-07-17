package com.volve.accl.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.volve.accl.domain.AuthenticationRequest;
import com.volve.accl.domain.AuthenticationResponse;
import com.volve.accl.domain.Client;
import com.volve.accl.domain.Users;
import com.volve.accl.payload.ClientRequest;
import com.volve.accl.repository.ClientInterface;
import com.volve.accl.security.JwtUtil;
import com.volve.accl.security.MyUserDetailsService;
import com.volve.accl.service.ClientService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private ClientService clientService;

	@RequestMapping("/")
	public String hello() {
		return "<h1>Hello World</h1>";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> signin(@RequestBody AuthenticationRequest authenticationRequest ) throws Exception {
		
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid credentials", e);
		}
		
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt  = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@RequestMapping(value="/create-client", method = RequestMethod.POST)
	public ResponseEntity<?> signup(@RequestBody ClientRequest client) throws Exception {
		 Users user = clientService.createClient(client);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
}
