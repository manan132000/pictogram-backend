package com.example.pictogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PictogramApplication {
	public static void main(String[] args) {
		SpringApplication.run(PictogramApplication.class, args);
	}

}
