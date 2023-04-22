package com.ssafy.ws.model.dto;

public class User {
	private String userId;
	private String userPass;
	private String userName;
	private String img;
	private String orgImg;
	
	public User() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + ", img=" + img
				+ ", orgImg=" + orgImg + "]";
	}
}
