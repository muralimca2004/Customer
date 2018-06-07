package com.maple.it.core.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
	
	@NotEmpty(message="Netbanking Id can not left blank")
	@Size(min=9, max=12, message="Netbanking Id size should be of length 9-12")
	private String uid;
	
	@NotNull
	@Size(min=9, max=12)
	private String password;
	
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginForm [uid=" + uid + ", password=" + password + "]";
	}
	
	
}
