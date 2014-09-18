package com.candi.actions;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.candi.beans.UserBean;
import com.candi.models.UserModel;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final Logger log = Logger.getLogger(Login.class.getName());
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp = ServletActionContext.getResponse();
	
	UserBean user = new UserBean(); 
	
	public String login() {

		UserService userService = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User guser = userService.getCurrentUser();
        String thisURL = req.getRequestURI();
        
		try{
			user.setLoginUrl(userService.createLoginURL(thisURL));
			user.setLogoutUrl(userService.createLogoutURL(thisURL));
			user.setName(req.getUserPrincipal().getName());
			user.setEmail(guser.getEmail());
			user.setNickname(guser.getNickname());
			user.setUserId(guser.getUserId());
			user.setAuthDomain(guser.getAuthDomain());
			user.setFederatedIdentity(guser.getFederatedIdentity());
			
			UserModel userModel = new UserModel();
			userModel.saveUsers(user);

			
		} catch(NullPointerException n) {
			user.setName(null);
		}
		
		this.setUser(this.user);

		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
	}
	
	public HttpServletResponse getServletResponse() {
		return this.resp;
	}	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
	}
	public HttpServletRequest getServletRequest() {
		return this.req;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public UserBean getUser() {
		return user;
	}

}
