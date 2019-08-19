package com.rahul.mymoviecinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyMovieInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMovieInfoServiceApplication.class, args);
	}

}
