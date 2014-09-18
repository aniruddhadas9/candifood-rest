package com.candi.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import java.util.logging.Logger;

import com.candi.beans.UserBean;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private static final Logger log = Logger.getLogger(Login.class.getName());
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp = ServletActionContext.getResponse();
	
	UserBean user = new UserBean(); 
	
	public String execute() {

		UserService userService = UserServiceFactory.getUserService();
		User guser = userService.getCurrentUser();
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
			
		} catch(NullPointerException n) {
			user.setName(null);
		}
		
		log.info("all set dude. we are going to jsp");
		
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
