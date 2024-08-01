package com.app.survey.app_survey;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class AppSurveyApplication {

	public static void main(String[] args) {
		//ESTA ES UNA FORMA DE CAMBIAR EL PUERTO DESDE EL MAIN
		SpringApplication app = new SpringApplication(AppSurveyApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8091"));
		app.run(args);

	}
}
