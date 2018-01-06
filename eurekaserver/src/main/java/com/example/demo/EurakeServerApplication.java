package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakeServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurakeServerApplication.class, args);
	}

//	public static void main(String[] args) {
//		new SpringApplicationBuilder(EurakeServerApplication.class).web(true).run(args);
//	}
}
