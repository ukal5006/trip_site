package com.example.trip.user.dto;

public class UserDTO {
	private String userId;
	private String userPwd;
	private String birth;
	private String userName;
	private String userPhone;
	private int admin;
	
	public UserDTO(String userId, String userPwd, String birth, String userName, String userPhone, int admin) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.birth = birth;
		this.userName = userName;
		this.userPhone = userPhone;
		this.admin = admin;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(String userId, String userPwd, String birth, String userName, String userPhone) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.birth = birth;
		this.userName = userName;
		this.userPhone = userPhone;
	}
	
	
	
	public UserDTO(String userId, String userPwd) {
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userPwd=" + userPwd + ", birth=" + birth + ", userName=" + userName
				+ ", userPhone=" + userPhone + "]";
	}
}
