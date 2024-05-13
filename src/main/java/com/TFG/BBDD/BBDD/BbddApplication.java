package com.TFG.BBDD.BBDD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.TFG.BBDD.BBDD.model")
public class BbddApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbddApplication.class, args);
	}

}
