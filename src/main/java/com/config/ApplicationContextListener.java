package com.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.controller.routing.ManagerFactory;

public class ApplicationContextListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("kai start");
		ManagerFactory.getInstance();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("kai stop");
		ManagerFactory.destroy();
	}

}
