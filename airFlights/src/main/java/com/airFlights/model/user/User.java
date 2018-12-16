package com.airFlights.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	public enum UserRole {
		CUSTOMER, AVIO_ADMIN, HOTEL_ADMIN, ADMIN_ADMIN 
	}
	
	@Id
	@GeneratedValue
	private Long userId;
	
	
	@Enumerated
	@Column(name = "role", columnDefinition = "tinyInt")
	private UserRole role;
	
	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String city;
	
	private String telephone;
	
	@Column(name = "activated")
	private Boolean activatedAccount;

	private Integer bonusPoints;
	
	@OneToMany(mappedBy = "userWhoInvite")
	private Set<Friendship> friendships = new HashSet<Friendship>();
	
	@OneToMany(mappedBy = "userWhoAccept")
	private Set<Friendship> requestedFriendships = new HashSet<Friendship>();
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(Integer bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public Boolean getActivatedAccount() {
		return activatedAccount;
	}

	public void setActivatedAccount(Boolean activatedAccount) {
		this.activatedAccount = activatedAccount;
	}
}
