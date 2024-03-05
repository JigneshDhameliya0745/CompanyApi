package com.companyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApiApplication.class, args);
		
		System.out.println("Started.....");
	}

}
