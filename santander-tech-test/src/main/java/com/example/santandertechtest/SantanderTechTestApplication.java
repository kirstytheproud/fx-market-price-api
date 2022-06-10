package com.example.santandertechtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@CrossOrigin
@RestController
public class SantanderTechTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderTechTestApplication.class, args);
	}

}