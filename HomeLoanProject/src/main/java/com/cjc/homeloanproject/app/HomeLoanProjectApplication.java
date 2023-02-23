package com.cjc.homeloanproject.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
public class HomeLoanProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeLoanProjectApplication.class, args);
	}

}
