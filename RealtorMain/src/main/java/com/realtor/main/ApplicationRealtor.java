package com.realtor.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({"com.realtor.*"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackages = {"com.realtor.*"})
@EnableJpaRepositories("com.realtor.*")
@EntityScan("com.realtor.*")
public class ApplicationRealtor{

	public static void main(String[] args) {
		 SpringApplication.run(ApplicationRealtor.class, args);
	}	 
}