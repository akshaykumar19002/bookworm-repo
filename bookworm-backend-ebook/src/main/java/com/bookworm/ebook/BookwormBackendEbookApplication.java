package com.bookworm.ebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.bookworm.ebook.entity")
@ComponentScan(basePackages = { "com.bookworm.*"})
@EnableJpaRepositories("com.bookworm.ebook.repo")
@SpringBootApplication
public class BookwormBackendEbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookwormBackendEbookApplication.class, args);
	}
	
}
