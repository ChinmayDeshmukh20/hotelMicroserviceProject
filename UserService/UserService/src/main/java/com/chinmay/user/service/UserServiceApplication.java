package com.chinmay.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {

//	@Bean           // by doing @Bean now we can use rest template in service impl file , rest template object will be provided whenever required , by just declaring rest template variable in service impl class and autowiring it
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}