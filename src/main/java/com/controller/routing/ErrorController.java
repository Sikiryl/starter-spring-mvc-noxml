package com.controller.routing;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	
	/*
	 * Container Error Page:
	 * <error-page>
	 * 		<error-code>404 or 500 </error-code>
	 * 		<location>/error</location>
	 * </error-page>
	 * 
	 * reference: https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-customer-servlet-container-error-page
	 */
	
	@RequestMapping(path = "/error")
    public Map<String, Object> handle(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason", request.getAttribute("javax.servlet.error.message"));
        return map;
    }

}
