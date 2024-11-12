package com.alura.literatura_challenge.repository;

import com.alura.literatura_challenge.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String name);
}
