package com.airFlights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AirFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirFlightsApplication.class, args);
	}
}
