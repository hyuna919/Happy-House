package com.ssafy.happyhouse.model.dto;

import java.io.Serializable;

import org.apache.ibatis.annotations.Mapper;

public class User implements Serializable {
	private String userId;
	private String userPw;
	private String userEmail;
	private String userPhone;
	private String userName;
	

	public User() {
		super();
	}

//	public User(String userPw, String userEmail) {
//		super();
//		this.userPw = userPw;
//		this.userEmail = userEmail;
//	}

	public User(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}

	public User(String userId, String userPw, String userEmail, String userPhone, String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userName=" + userName + "]";
	}
}
