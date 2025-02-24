package com.expense.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.expense.userservice.entities" })
@EnableJpaRepositories(basePackages = { "com.expense.userservice.repository" })
@ComponentScan(basePackages = { "com.expense.userservice.consumer", "com.expense.userservice.service",
		"com.expense.userservice.config" })
public class UserserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
