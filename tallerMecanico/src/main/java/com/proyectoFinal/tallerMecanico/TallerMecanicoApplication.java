package com.proyectoFinal.tallerMecanico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TallerMecanicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerMecanicoApplication.class, args);
	}

}
