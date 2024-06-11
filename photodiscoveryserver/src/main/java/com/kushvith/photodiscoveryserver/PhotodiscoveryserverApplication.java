package com.kushvith.photodiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotodiscoveryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotodiscoveryserverApplication.class, args);
	}

}
