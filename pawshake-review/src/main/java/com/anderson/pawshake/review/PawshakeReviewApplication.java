package com.anderson.pawshake.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PawshakeReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawshakeReviewApplication.class, args);
	}

}
