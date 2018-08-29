package com.httppostrequestvisualizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MainApplication {

	Logger logger = Logger.getLogger(MainApplication.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            
            logger.info("Application started. Waiting for post requests...");

        };
    }
}
