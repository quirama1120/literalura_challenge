package com.alura.literatura_challenge.service;

import com.alura.literatura_challenge.model.Author;
import com.alura.literatura_challenge.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsInDataBase {
    private AuthorRepository authorRepository;

    @Autowired
    public void authorsInDataBase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void authorsInDatabase() {
        List<Author> existingAuthors = authorRepository.findAll();
        existingAuthors.forEach(author -> System.out.println(formatAuthorOutput(author)));
    }

    private String formatAuthorOutput(Author author) {
        return author.toString();
    }
}
