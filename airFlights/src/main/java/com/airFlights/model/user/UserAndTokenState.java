package com.airFlights.model.user;

public class UserAndTokenState {

	private String username;
	private String accessToken;
    private Long expiresIn;

    public UserAndTokenState() {
        this.accessToken = null;
        this.expiresIn = null;
    }

    public UserAndTokenState(String username, String accessToken, long expiresIn) {
        this.username = username;
    	this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    } 

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

}
