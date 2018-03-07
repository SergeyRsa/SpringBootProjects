package com.in28minutes.springboot.rest.example;
	
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJPAApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJPAApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJPAApplication.class);
	}

	@Bean
	public CommandLineRunner demo(BookRepositroy repository) {
		return (args) -> {
			// save a couple of books
			repository.save(new Books("Introduction to algorithms","Corman",200));
			repository.save(new Books("Da Vinci Code","Dan Brown",20));
			repository.save(new Books("Fraud analytics","Mel Gibson",10));
			repository.save(new Books("Grammar perfection","Pushkin",12));
			repository.save(new Books("War and peace","Tolstoy",5));
						
			// fetch all books
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Books books : repository.findAll()) {
				log.info(books.toString());
			}
			log.info("");

			
			// fetch all books by Author
			log.info("Books found with findByAuthor('Tolstoy'):");
			log.info("--------------------------------------------");
			repository.findByAuthor("Tolstoy").forEach(tolstoy -> {
				log.info(tolstoy.toString());
			});
			log.info("");
		};
	}

}