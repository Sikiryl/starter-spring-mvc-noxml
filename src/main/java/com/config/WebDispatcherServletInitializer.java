package com.config;

import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/*
	 * no (.xml) references:
	 * http://joshlong.com/jl/blogPost/simplified_web_configuration_with_spring.html
	 * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc
	 */
	
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("onStartup");
		super.onStartup(servletContext);
	}
	
	
	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
		System.out.println("registerContextLoaderListener");
		servletContext.setInitParameter("isLog4jAutoInitializationDisabled", "true");
		
		
		super.registerContextLoaderListener(servletContext);
	}
	
	private void setJavaMelodyConfiguration(ServletContext servletContext) {
		
		 servletContext.setInitParameter("javamelody.enabled", "true");
		 servletContext.setInitParameter("javamelody.storage-directory", "/opt/javamelody");
		 servletContext.setInitParameter("javamelody.authorized-users", "admin:admin");
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses");
		return  new Class[] { BaseConfig.class };
	}
	
	/* <listener> */
	@Override
	protected void registerDispatcherServlet(ServletContext servletContext) {
		setJavaMelodyConfiguration(servletContext);
		servletContext.addListener(ApplicationContextListener.class);
		/* <session-config> 
		 * 		<tracking-mode>COOKIE</tracking-mode>
		 * 		<session-timeout>30</session-timeout> 
		 * </session-config>
		 */
		HashSet<SessionTrackingMode> sessionTrackingModes = new HashSet<SessionTrackingMode>();
		sessionTrackingModes.add(SessionTrackingMode.COOKIE);
		servletContext.setSessionTrackingModes(sessionTrackingModes);
		servletContext.addListener(new SessionListener());
		super.registerDispatcherServlet(servletContext);
	}
	
	
	/*
	 * HiddenHttpMethodFilter: https://stackoverflow.com/questions/34048617/spring-boot-how-to-use-
	 * CharacterEncodingFilter: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/filter/CharacterEncodingFilter.html
	 */
	
	/* <servlet> */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses");
		return new Class[] {
				SpringApplicationConfiguration.class
				};
	}

	/* <servlet-mapping> */
	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings:");
		return new String[] { "/" };
	}
	
	 /* <filter-mapping> */
	@Override
	protected Filter[] getServletFilters() {
		System.out.println("check in getServletFilter");
//		MonitoringFilter monitoringFilter = new MonitoringFilter();
		return new Filter[] {
	            new HiddenHttpMethodFilter(), 
	            new CharacterEncodingFilter("UTF-8", true),
	    };
	}
	
	@Override
	protected Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
		System.out.println("registerServletFilter");
		return super.registerServletFilter(servletContext, filter);
	}
	
}
