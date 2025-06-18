package com.example.APITest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.example", "com.example"})
public class ApiTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}
}