package com.candi.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

 
import ognl.OgnlRuntime;
 
public class Struts2ListenerOnGAE implements ServletContextListener,
		HttpSessionListener, HttpSessionAttributeListener {
 
	private static final Logger log = Logger.getLogger(Struts2ListenerOnGAE.class.getName());
	
	public void contextInitialized(ServletContextEvent sce) {
		log.info("Aniruddha - manual GAP struts2 listener: Listener is called successfully");
		OgnlRuntime.setSecurityManager(null);
	}
 
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
 
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}
 
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
	}
 
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
	}
 
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
	}
 
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
	}
 
}