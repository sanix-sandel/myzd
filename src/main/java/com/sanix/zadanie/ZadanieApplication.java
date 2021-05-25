package com.sanix.zadanie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZadanieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZadanieApplication.class, args);
	}

}
/*

spring.data.mongodb.database=test
spring.data.mongodb.port=27017
spring.data.mongodb.host=mongodb
spring.data.mongodb.username=root
spring.data.mongodb.password=12345678
spring.data.mongodb.gridFsDatabase=test
spring.data.mongodb.repositories.enabled=true

org.springframework.web.filter.CommonsRequestLoggingFilter=DEBUG

 */