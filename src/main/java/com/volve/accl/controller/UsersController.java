package com.volve.accl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.volve.accl.domain.Users;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.pojo.AuthenticationRequest;
import com.volve.accl.pojo.AuthenticationResponse;
import com.volve.accl.pojo.GlobalResponse;
import com.volve.accl.security.JwtUtil;
import com.volve.accl.security.MyUserDetailsService;
import com.volve.accl.service.UsersService;

@RestController
@RequestMapping("/auth")
public class UsersController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UsersService usersService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String hello() {
		return "<h1>Hello World</h1>";
	}

	/**
	 * 
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> signin(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

			final String jwt = jwtUtil.generateToken(userDetails);

			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		} catch (Exception e) {
			throw new Exception("Invalid credentials", e);

		}
	}

	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> signup(@RequestBody Users user) throws Exception {
		return new ResponseEntity<Users>(usersService.signup(user), HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> listUsers() {
		try {
			return new ResponseEntity<GlobalResponse>(usersService.listUsers(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/approveAttorney/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> approveAttorney(@PathVariable("id") String id) {
		try {
			Users userToApprove = usersService.approveAttorney(id);
			if (userToApprove.getActive() == true) {
				return new ResponseEntity<String>("Approved successful", HttpStatus.CREATED);
			}
			return new ResponseEntity<String>("Not Approved successful", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/rateAttorney/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> rateAttorney(@PathVariable("id") String id) {
		try {
			return new ResponseEntity<GlobalResponse>(usersService.rateAttorney(id), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			throw new HandlerInternalServerErrorException("Server errorrr");
		}
	}
}
