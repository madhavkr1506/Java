package com.example.formsubmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class FormsubmissionApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(FormsubmissionApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(FormsubmissionApplication.class, args);
	}

}
