package com.uw.oris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class LaureateCountApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaureateCountApplication.class, args);
	}

}
