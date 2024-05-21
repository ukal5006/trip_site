package com.example.trip.user.dto;

import java.util.Date;

public class UserDTO {
	private String userId;
	private String userPwd;
	private Date birth;
	private String userName;
	private String userPhone;
	private String userEmail;
	private int admin;

	public UserDTO(String userId, String userPwd, Date birth, String userName, String userPhone, String userEmail,
			int admin) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.birth = birth;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.admin = admin;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(String userName, Date birth, String userPhone, String userEmail) {
		this.userName = userName;
		this.birth = birth;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public UserDTO(String userId, String userName, Date birth, String userPhone, String userEmail) {
		this.userId = userId;
		this.userName = userName;
		this.birth = birth;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public UserDTO(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public UserDTO(String userId) {
		this.userId = userId;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", admin=" + admin + "]";
	}

}
