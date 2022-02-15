package br.com.examplesecurity.security.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class UserDTO {

	private String userName;
	private boolean active;
	private String roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public UserDTO() {
	}

	public UserDTO(UserDetails principal) {
		this.userName = principal.getUsername();
		this.active = principal.isEnabled();
		this.roles = principal.getAuthorities().toString().replace("[", "").replace("]", "");
	}
}
