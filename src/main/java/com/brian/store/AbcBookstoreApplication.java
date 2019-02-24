package com.brian.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AbcBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcBookstoreApplication.class, args);
	}

}

