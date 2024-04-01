package com.evadLearning.jpa;

import com.evadLearning.jpa.models.Author;
import com.evadLearning.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

//	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository
	){
		return args -> {
			var author = Author.builder()
					.firstName("evad")
					.lastName("neskaju")
					.age(99)
					.email("test@mail.com")
					.build();
			repository.save(author);
		};
	}

}
