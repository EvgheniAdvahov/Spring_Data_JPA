package com.evadLearning.jpa.repositories;

import com.evadLearning.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthoresAges(int age);

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
