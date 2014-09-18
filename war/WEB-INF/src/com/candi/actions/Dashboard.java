package com.candi.actions;

import com.candi.beans.UserBean;
import com.candi.models.UserModel;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import com.opensymphony.xwork2.ActionSupport;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class Dashboard extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private static final Logger log = Logger.getLogger(Login.class.getName());
	
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp = ServletActionContext.getResponse();
	
	UserBean user = new UserBean(); 
	
	private String vendorData;
	
	public String execute() {
		log.info("inside the execute method of the Dashboard class");
		return SUCCESS;
		
	}

	public String dashboard() {
		log.info("inside the dashboard method of the Dashboard class");
		return SUCCESS;
	}
	
	public String countLdap() {
		log.info("inside the countLdap method of the Dashboard class");
		return SUCCESS;
	}
	
	public String noAction() throws Exception {
		log.info("Aniruddha in noAction and loafing vendor data");
		UserService userService = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User guser = userService.getCurrentUser();
        String thisURL = req.getRequestURI();
        
        
		try{
			log.info("setting user data and links");
			user.setLoginUrl(userService.createLoginURL(thisURL));
			user.setLogoutUrl(userService.createLogoutURL(thisURL));
			user.setName(req.getUserPrincipal().getName());
			log.info("got the name and authenticated");
			user.setEmail(guser.getEmail());
			user.setNickname(guser.getNickname());
			user.setUserId(guser.getUserId());
			user.setAuthDomain(guser.getAuthDomain());
			user.setFederatedIdentity(guser.getFederatedIdentity());
			
			//storing the data to the datatore
			UserModel userModel = new UserModel();
			userModel.saveUsers(user);
			
		} catch(NullPointerException n) {
			log.info("name is null so doing the authentication");
			user.setName(null);
			resp.sendRedirect(userService.createLoginURL(thisURL));
			log.info("after sendRedirect");
		    return super.execute();
			
		}
		
		this.setUser(this.user);
		
		return SUCCESS;
	}
	
	
	public String getVendorData() {
		return vendorData;
	}

	public void setVendorData(String vendorData) {
		//readData rd = new readData();
		this.vendorData = vendorData; //rd.getData();
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
