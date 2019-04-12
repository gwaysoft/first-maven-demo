package com.gwaysoft.firstappdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.gwaysoft.firstappdemo.web.servlet")
public class FirstAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppDemoApplication.class, args);
	}

}
