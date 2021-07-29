package com.coronation.sevenupApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SevenupAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SevenupAppApplication.class, args);
		
	}

	
}
