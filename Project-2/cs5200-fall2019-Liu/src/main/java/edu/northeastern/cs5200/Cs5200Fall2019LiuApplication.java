package edu.northeastern.cs5200;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
@SpringBootApplication
public class Cs5200Fall2019LiuApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cs5200Fall2019LiuApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(Cs5200Fall2019LiuApplication.class,args);
	}
	
}

