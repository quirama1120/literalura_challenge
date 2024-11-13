package com.alura.literatura_challenge.service;

import com.alura.literatura_challenge.model.Book;
import com.alura.literatura_challenge.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksInDatabase {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksInDatabase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void booksInDatabaseSearch() {
        List<Book> existingBooks = booksRepository.findAll();

        existingBooks.forEach(book -> System.out.println(formatBookOutput(book)));
    }

    private String formatBookOutput(Book book) {
        return "Título: " + book.getTitle() +
                ", Autor(es): " + book.getAuthors().get(0).getName() +
                ", Descargas: " + book.getDownload_count();
    }
}
