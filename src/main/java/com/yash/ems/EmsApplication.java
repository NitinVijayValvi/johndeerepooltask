package com.yash.ems;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.slf4j.Logger;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ConfigurationProperties
@PropertySource(value = {"file:C:/Users/nitin.valvi/Documents/myprop/myapp.properties.txt"})
public class EmsApplication implements CommandLineRunner {

	Logger logger= LoggerFactory.getLogger(EmsApplication.class);
	
	@Value("${myapp.language}")
	String lang;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.yash.ems"))
				.build();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("language is=  "+lang);
	}
}
