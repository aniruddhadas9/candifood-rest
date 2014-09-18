package com.candi.beans;

import java.io.Serializable;

public class RestaurantBean implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String localtion;
	private String address;
	private String phone;
	private String status;
	private String rating;
	private String openTime;
	private String closeTime;
	private String deliveryMinimum;
	private String deliveryCharge;
	private String onlinePayment;
	private String offer;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocaltion() {
		return localtion;
	}
	public void setLocaltion(String localtion) {
		this.localtion = localtion;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getDeliveryMinimum() {
		return deliveryMinimum;
	}
	public void setDeliveryMinimum(String deliveryMinimum) {
		this.deliveryMinimum = deliveryMinimum;
	}
	public String getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public String getOnlinePayment() {
		return onlinePayment;
	}
	public void setOnlinePayment(String onlinePayment) {
		this.onlinePayment = onlinePayment;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}


}
