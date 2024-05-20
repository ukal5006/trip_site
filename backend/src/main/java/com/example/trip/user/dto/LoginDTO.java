package com.example.trip.user.dto;

public class LoginDTO {
	private String userId;
	private String userPwd;

	public LoginDTO() {
		super();
	}

	public LoginDTO(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", userPwd=" + userPwd + "]";
	}

}
