package com.ssafy.happyhouse.model.dto;

public class Like {
	String no;
	String userId;
	String houseNo;
	
	
	
	public Like(String userId, String houseNo) {
		super();
		this.userId = userId;
		this.houseNo = houseNo;
	}
	public Like(String no, String userId, String houseNo) {
		super();
		this.no  = no;
		this.userId = userId;
		this.houseNo = houseNo;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	
	

		
}
