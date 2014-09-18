package com.candi.actions;

import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.candi.jpa.Employee;
import com.candi.listeners.EMF;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.candi.beans.UserBean;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

public class Restaurant extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Restaurant.class.getName());
	
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp = ServletActionContext.getResponse();
	
	UserBean user = new UserBean();
	
	EntityManager em = EMF.get().createEntityManager();
	
	
	
	public String dashboard() {
		log.info("I am int he Restaurant->dashboard");
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
			
		} catch(NullPointerException n) {
			user.setName(null);
		}
		
		this.setUser(this.user);

		return SUCCESS;
	}

	public String add() {
		log.info("I am int he Restaurant->add");
		UserService userService = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User guser = userService.getCurrentUser();
        String thisURL = req.getRequestURI();
        
        if(req.getContentLength()==0) {
        	return "input";
        }
        
        
        
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
		
		this.setUser(this.user);

		return SUCCESS;
	}
	
	public String addEmployee(){
		log.info("I am int he Restaurant->addEmployee");
		Employee emp = new Employee();
		emp.setFirstName("Candi food");
		emp.setLastName("Restaurnat");
		emp.setHireDate(new Date());
		
		try {
			em.persist(emp);
			//em.flush();
			log.info("Restaurant->addEmployee: added to the database");
	    } finally {
	        em.close();
	    }
		
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
