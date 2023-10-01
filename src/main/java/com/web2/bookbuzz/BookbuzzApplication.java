package com.web2.bookbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.web2.bookbuzz.repositories")
public class BookbuzzApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookbuzzApplication.class, args);
	}
}
