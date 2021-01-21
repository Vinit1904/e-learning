package com.cdac.elearning.dto;

public class LoginResponse extends Status{
	private String name;
	private String authToken;
	
	public LoginResponse() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
}
