package com.candi.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class VenderRedirect extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String add() throws Exception{
        String email = (String) session.get("email");
        if ( email == null)
            return LOGIN; 

        //business logic here

        return SUCCESS;
    }
}