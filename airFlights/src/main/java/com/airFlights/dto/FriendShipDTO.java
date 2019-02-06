package com.airFlights.dto;

import com.airFlights.model.user.Friendship;
import com.airFlights.model.user.User;

public class FriendShipDTO {
	
	private Integer friendshipId;
	
	private UserDTO userWhoInvite;
	private UserDTO userWhoAccept;
	private Boolean established;
	
	public FriendShipDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendShipDTO(Integer friendshipId, User userWhoInvite, User userWhoAccept, Boolean established) {
		super();
		this.friendshipId = friendshipId;
		this.established = established;

		
		this.userWhoInvite = new UserDTO(userWhoInvite.getId(), userWhoInvite.getUsername(), userWhoInvite.getFirstName(), userWhoInvite.getLastName(), userWhoInvite.getEmail(),
				userWhoInvite.getCity(), userWhoInvite.getPhone_number());
		this.userWhoAccept = new UserDTO(userWhoAccept.getId(), userWhoAccept.getUsername(), userWhoAccept.getFirstName(), userWhoAccept.getLastName(), userWhoAccept.getEmail(),
				userWhoAccept.getCity(), userWhoAccept.getPhone_number());
	}
	
	public FriendShipDTO(Friendship f) {
		this(f.getFriendshipId(), f.getUserWhoInvite(), f.getUserWhoAccept(), f.getEstablished());
	}

	public Integer getFriendshipId() {
		return friendshipId;
	}

	public void setFriendshipId(Integer friendshipId) {
		this.friendshipId = friendshipId;
	}

	public UserDTO getUserWhoInvite() {
		return userWhoInvite;
	}

	public void setUserWhoInvite(UserDTO userWhoInvite) {
		this.userWhoInvite = userWhoInvite;
	}

	public UserDTO getUserWhoAccept() {
		return userWhoAccept;
	}

	public void setUserWhoAccept(UserDTO userWhoAccept) {
		this.userWhoAccept = userWhoAccept;
	}

	public Boolean getEstablished() {
		return established;
	}

	public void setEstablished(Boolean established) {
		this.established = established;
	}
	
	

}
