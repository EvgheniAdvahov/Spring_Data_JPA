package com.evadLearning.jpa.repositories;

import com.evadLearning.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
