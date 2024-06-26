package com.evadLearning.jpa;

import com.evadLearning.jpa.models.Author;
import com.evadLearning.jpa.models.Video;
import com.evadLearning.jpa.repositories.AuthorRepository;
import com.evadLearning.jpa.repositories.VideoRepository;
import com.evadLearning.jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

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
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.name().username() + "@mail.com")
						.build();
//				repository.save(author);
			}

			//update author with ID 1
//			var author = Author.builder()
//					.id(1)
//					.firstName("Evgheni")
//					.lastName("Advahov")
//					.age(36)
//					.email("evgheniAdvahov@mail.com")
//					.build();
//			repository.save(author);

			// update Author a set a.age = 22 where a.id = 1
//			repository.updateAuthor(37, 1);

			// update all Authors age
//			repository.updateAllAuthoresAges(21);

			// find all by named quer
//			repository.findByNamedQuery(45)
//					.forEach(System.out::println);

			//update by named query
//			repository.updateNamedQuery(22);

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(43))
					.or(AuthorSpecification.firstnameLike("Merlin"));

			repository.findAll(spec).forEach(System.out::println);

			/*var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);*/
		};
	}

}