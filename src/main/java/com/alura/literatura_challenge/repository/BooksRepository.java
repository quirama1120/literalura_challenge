package com.alura.literatura_challenge.repository;
import com.alura.literatura_challenge.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String name);
    @Query("SELECT b FROM Book b JOIN b.languages l WHERE l = :language")
    List<Book> findBooksByLanguage(@Param("language") String language);
}
