package com.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	private static int THIRTY_MINUTE = 30*60;
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setMaxInactiveInterval(THIRTY_MINUTE);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

	}

}
