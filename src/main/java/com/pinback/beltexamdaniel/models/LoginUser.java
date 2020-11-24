package com.pinback.beltexamdaniel.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {

	@NotEmpty(message="Email is required")
    @Email(message="Invalid email")
    private String email;
    
	@NotEmpty(message="Password is required")
    @Size(min=8, message="Password must be 8 characters or longer")
    private String password;

	public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
