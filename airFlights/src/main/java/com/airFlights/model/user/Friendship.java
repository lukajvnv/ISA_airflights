package com.airFlights.model.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Friendship {

	@Id
	@GeneratedValue
	private Long friendshipId;
	
	@ManyToOne
	@JoinColumn(name = "inviter_id")
	private User userWhoInvite;
	
	@ManyToOne
	@JoinColumn(name = "accepter_id")
	private User userWhoAccept;
	
	private Date dateOfRequest;
	
	private Boolean established;

	public Long getFriendshipId() {
		return friendshipId;
	}

	public void setFriendshipId(Long friendshipId) {
		this.friendshipId = friendshipId;
	}

	public User getUserWhoInvite() {
		return userWhoInvite;
	}

	public void setUserWhoInvite(User userWhoInvite) {
		this.userWhoInvite = userWhoInvite;
	}

	public User getUserWhoAccept() {
		return userWhoAccept;
	}

	public void setUserWhoAccept(User userWhoAccept) {
		this.userWhoAccept = userWhoAccept;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public Boolean getEstablished() {
		return established;
	}

	public void setEstablished(Boolean established) {
		this.established = established;
	}

	public Friendship() {
		super();
		// TODO Auto-generated constructor stub
	}
}
