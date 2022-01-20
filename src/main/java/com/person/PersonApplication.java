package com.person;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication


public class PersonApplication {

	//static org.apache.logging.log4j.Logger logger=LogManager.getLogger(PersonApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
		
//		System.out.println("hello.....");
//		logger.trace("[getMessage] trace message");
//		logger.info("[getMessage]info message");
//		logger.warn("[getMessage] warning message");
//		logger.error("[getMessage] error message");
//		logger.debug("[getMessage] debug message");
//		logger.fatal("[getMessage] fatal message");
//
		
	}

//	@Bean
//public Docket swaggerCongig() {
//	
//	return new Docket(DocumentationType.SWAGGER_2).select()
//			.paths(PathSelectors.ant("/person/*"))
//			.apis(RequestHandlerSelectors.basePackage("com.person.controller.PersonController"))
//			.build();
//}
}
