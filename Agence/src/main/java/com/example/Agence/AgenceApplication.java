package com.example.Agence;

import com.example.Agence.GUI.HotelAgencyMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.example.Agence.models",
		"com.example.Agence.client",
		"com.example.Agence.GUI",
		"com.example.Agence.DTO",
})
public class AgenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceApplication.class, args);
		HotelAgencyMain hotel=new HotelAgencyMain();
	}

}
