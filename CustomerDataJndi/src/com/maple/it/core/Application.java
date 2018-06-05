package com.maple.it.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@EnableAutoConfiguration
@PropertySource({"classpath:resources/application.properties"})
public class Application{

	/**
	 * Default constructor
	 */
	public Application() {
		
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
	}

}
