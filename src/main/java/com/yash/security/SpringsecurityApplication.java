package com.yash.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringsecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.yash.security"))
				.build();
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
