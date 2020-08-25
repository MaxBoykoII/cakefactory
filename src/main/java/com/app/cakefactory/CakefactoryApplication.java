package com.app.cakefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CakefactoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(CakefactoryApplication.class, args);
		System.out.println("Getting ready to open up the cake factory...");
	}

}
