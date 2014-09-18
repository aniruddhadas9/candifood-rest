package com.candi.models;

import java.util.Date;

import com.candi.beans.UserBean;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class UserModel {
	
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public boolean saveUsers(UserBean userBean) {
		Date createDate = new Date();
		Entity user = new Entity("users", userBean.getEmail());

		
		user.setProperty("name", userBean.getName());
		user.setProperty("email", userBean.getEmail());
		user.setProperty("address", userBean.getAddress());
		user.setProperty("phone", userBean.getPhone());
		
		user.setProperty("userId", userBean.getUserId());
		user.setProperty("loginUrl", userBean.getLoginUrl());
		user.setProperty("logoutUrl", userBean.getLogoutUrl());
		user.setProperty("nickname", userBean.getNickname());
		user.setProperty("authDomain", userBean.getAuthDomain());
		user.setProperty("federatedIdentity", userBean.getFederatedIdentity());
		user.setProperty("creation", createDate);

		datastore.put(user);

		return true;
	}

}
