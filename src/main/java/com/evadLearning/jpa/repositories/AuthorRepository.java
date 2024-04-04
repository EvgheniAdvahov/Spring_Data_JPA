package com.evadLearning.jpa.repositories;

import com.evadLearning.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // select * from author where first_name = 'ev'
    List<Author> findAllByFirstName(String fname);

    // select * from author where first_name = 'ev'
    List<Author> findAllByFirstNameIgnoreCase(String fname);

    // select * from author where first_name like '%ev%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fname);

    // select * from author where first_name like 'ev%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fname);

    // select * from author where first_name like '%ni'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fname);

    // select * from author where first_name in ('evg', 'heni', 'coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> fname);

}
