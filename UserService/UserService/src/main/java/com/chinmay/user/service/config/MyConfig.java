package com.chinmay.user.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

	@Bean           // by doing @Bean now we can use rest template in service impl file , rest template object will be provided whenever required , by just declaring rest template variable in service impl class and autowiring it
	@LoadBalanced		
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	
	// you dont need to create separate config class for declaring beans , this can also be done in main class 
	
	
	
}
