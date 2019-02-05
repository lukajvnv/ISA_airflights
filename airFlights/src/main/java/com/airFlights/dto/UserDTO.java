package com.airFlights.dto;

import java.sql.Timestamp;

public class UserDTO {

	private Long id;
	
    private String username;

    private String password;
    
    private String passwordCheck;
    
    private String role;

    private String firstName;

    private String lastName;

    private String email;
   
    private String city;
    
    private Long phone_number;

    private boolean enabled;

    private Timestamp lastPasswordResetDate;
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String username, String password, String passwordCheck, String role, String firstName, String lastName,
			String email, String city, Long phone_number, boolean enabled, Timestamp lastPasswordResetDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.phone_number = phone_number;
		this.enabled = enabled;
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public UserDTO(Long id, String username, String firstName, String lastName, String email, String city,
			Long phone_number) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.phone_number = phone_number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Timestamp getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

}
