package com.framtiden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
	/**
	 * Starts the main function
	 * 
	 * @param args Input from command prompt
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}