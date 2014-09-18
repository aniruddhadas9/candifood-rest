package com.candi.beans;

import java.io.Serializable;

public class UserBean implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String userType;
	
	
	private String loginUrl;
	private String logoutUrl;
	private String nickname;
	private String authDomain;
	private String federatedIdentity;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAuthDomain() {
		return authDomain;
	}
	public void setAuthDomain(String authDomain) {
		this.authDomain = authDomain;
	}
	public String getFederatedIdentity() {
		return federatedIdentity;
	}
	public void setFederatedIdentity(String federatedIdentity) {
		this.federatedIdentity = federatedIdentity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getLogoutUrl() {
		return logoutUrl;
	}
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	

}
