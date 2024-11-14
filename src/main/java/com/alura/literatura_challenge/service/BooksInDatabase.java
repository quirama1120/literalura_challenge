package com.alura.literatura_challenge.service;

import com.alura.literatura_challenge.model.Book;
import com.alura.literatura_challenge.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class BooksInDatabase {
    private final BooksRepository booksRepository;
    private final Scanner KEYWORD = new Scanner(System.in);

    @Autowired
    public BooksInDatabase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void booksInDatabaseSearch() {
        List<Book> existingBooks = booksRepository.findAll();

        existingBooks.forEach(book -> System.out.println(formatBookOutput(book)));
    }

    public void displayBooksByLanguage() {
        System.out.println("""
                Ingresa el idioma por el que quieres filtrar los libros correspondientes:
                Ejemplos del formato a filtrar: it, es, hu, fi, ca, en, etc...
                """);
        String language = KEYWORD.nextLine();
        List<Book> booksInLanguage = booksRepository.findBooksByLanguage(language);
        System.out.println(formatLanguageOutput(booksInLanguage, language));
    }

    private String formatLanguageOutput(List<Book> books, String language) {
        StringBuilder output = new StringBuilder("Libros en el idioma " + language + ":\n");

        for (Book book : books) {
            output.append("Título: ").append(book.getTitle())
                    .append("\nAutores: ").append(book.getAuthors())
                    .append("\nDescargas: ").append(book.getDownload_count())
                    .append("\n--------------------------------\n");
        }

        return output.toString();
    }

    private String formatBookOutput(Book book) {
        return "Título: " + book.getTitle() +
                ", Autor(es): " + book.getAuthors().get(0).getName() +
                ", Descargas: " + book.getDownload_count();
    }
}