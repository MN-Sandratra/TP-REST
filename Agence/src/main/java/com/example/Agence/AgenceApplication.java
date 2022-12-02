package com.example.Agence;

import com.example.Agence.GUI.HotelAgencyMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class AgenceApplication {

	public static void main(String[] args) {
		ApplicationContext contexto = new SpringApplicationBuilder(AgenceApplication.class)
				.headless(false)
				.run(args);
	}

}
