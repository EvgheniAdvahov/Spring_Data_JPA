package com.evadLearning.jpa;

import com.evadLearning.jpa.models.Author;
import com.evadLearning.jpa.models.Video;
import com.evadLearning.jpa.repositories.AuthorRepository;
import com.evadLearning.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository
	){
		return args -> {
		/*	var author = Author.builder()
					.firstName("evad")
					.lastName("neskaju")
					.age(99)
					.email("test@mail.com")
					.build();
			repository.save(author); */
			var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);
		};
	}

}
