package com.pixeon.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Gerusa
 *
 */
@SpringBootApplication
public class PixeonApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PixeonApiApplication.class, args);
	}
	
	//fazer deploy com o war
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
	    return application.sources(PixeonApiApplication.class);
	}

}
