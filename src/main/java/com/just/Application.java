package com.just;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


/**
 * Main class.
 * @author Alberto Sainz
 *
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	
    @Bean
    public ModelMapper modelMapper() {
     return new ModelMapper();
    }
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
