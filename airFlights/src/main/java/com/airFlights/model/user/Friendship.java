package com.airFlights.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Friendship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer friendshipId;
	
	@ManyToOne
	@JoinColumn(name = "inviter_id")
	private User userWhoInvite;
	
	@ManyToOne
	@JoinColumn(name = "accepter_id")
	private User userWhoAccept;
	
	// private Date dateOfRequest;
	
	private Boolean established;
	
	public Friendship() {
		super();
	}

	public Friendship(User userWhoInvite, User userWhoAccept, Boolean established) {
		super();
		this.userWhoInvite = userWhoInvite;
		this.userWhoAccept = userWhoAccept;
		this.established = established;
	}

	public Integer getFriendshipId() {
		return friendshipId;
	}

	public void setFriendshipId(Integer friendshipId) {
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

//	public Date getDateOfRequest() {
//		return dateOfRequest;
//	}
//
//	public void setDateOfRequest(Date dateOfRequest) {
//		this.dateOfRequest = dateOfRequest;
//	}

	public Boolean getEstablished() {
		return established;
	}

	public void setEstablished(Boolean established) {
		this.established = established;
	}

	
}
