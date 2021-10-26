package com.volve.accl.pojo;

public class AuthenticationResponse {
	
	private String jwt;	
	private String role;
	public AuthenticationResponse() {
	}
	
	public AuthenticationResponse(String jwt, String role) {
		this.jwt = jwt;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
