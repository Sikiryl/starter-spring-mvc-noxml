package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"inzane.config"})
@PropertySource("classpath:application.properties")
public class BaseConfig {
	
	@Value("${web.db.driver}")
	public String DB_DRIVER;
	@Value("${web.db.url}")
	public String DB_URL;
	@Value("${web.db.username}")
	public String DB_USERNAME;
	@Value("${web.db.password}")
	public String DB_PASSWORD;
	@Value("${web.db.init-size}")
	public int DB_INIT_SIZE;
	@Value("${web.db.max-active}")
	public int DB_MAX_ACTIVE;
	@Value("${web.db.min-idle}")
	public int DB_MIN_IDLE;
	
	/**
	   * Definitions properties files.
	   * @return properties files
	   */
	  @Bean
	  public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	  }
	  
}
