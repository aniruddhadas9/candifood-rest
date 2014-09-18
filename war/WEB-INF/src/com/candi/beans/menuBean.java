package com.candi.beans;

import java.io.Serializable;

public class menuBean  implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String item;
	private String price;
	
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
