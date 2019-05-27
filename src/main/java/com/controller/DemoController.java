package com.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.db.ConfigDB;

@Controller
public class DemoController {
	
	@Autowired
	private ConfigDB configDB;
	
	@GetMapping("/")
	public String showHome() throws SQLException {
		Map<String, String> ab = configDB.loadAllConfig();
		for(Map.Entry<String, String> entry : ab.entrySet()) {
			System.out.println("a: "+ entry.getKey() + " K: "+entry.getValue());
		}
		return "home";
	}
	

}
