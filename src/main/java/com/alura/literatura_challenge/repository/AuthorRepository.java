package com.alura.literatura_challenge.repository;
import com.alura.literatura_challenge.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
    @Query("SELECT a FROM Author a WHERE a.birth_year <= :year AND (a.death_year IS NULL OR a.death_year >= :year)")
    List<Author> findAuthorsAliveInYear(@Param("year") int year);
}
