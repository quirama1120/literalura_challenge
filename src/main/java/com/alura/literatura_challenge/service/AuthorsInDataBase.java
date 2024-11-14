package com.alura.literatura_challenge.service;

import com.alura.literatura_challenge.model.Author;
import com.alura.literatura_challenge.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AuthorsInDataBase {
    private AuthorRepository authorRepository;
    private final Scanner keyword = new Scanner(System.in);
    @Autowired
    public void authorsInDataBase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void authorsInDatabase() {
        List<Author> existingAuthors = authorRepository.findAll();
        existingAuthors.forEach(author -> System.out.println(formatAuthorOutput(author)));
    }

    public void livingAuthorsOnDate () {
        System.out.println("Ingresa el año para consultar los autores vivos.");
        int inputDate = keyword.nextInt();
        keyword.nextLine();
        List <Author> authorsAliveInYear = authorRepository.findAuthorsAliveInYear(inputDate);
        System.out.println(formatAuthorLivingOutput(authorsAliveInYear, inputDate));
    }

    private String formatAuthorOutput(Author author) {
        return author.toString();
    }
    private String formatAuthorLivingOutput(List<Author> authors, Integer date) {

        StringBuilder output = new StringBuilder("Autores vivos en el año " + date + ":\n");

        for (Author author : authors) {
            output.append("Nombre: ").append(author.getName())
                    .append("\nAño de Nacimiento: ").append(author.getBirth_year())
                    .append("\nAño de Muerte: ")
                    .append(author.getDeath_year() != null ? author.getDeath_year() : "Aún vivo")
                    .append("\n--------------------------------\n");
        }
        return output.toString();
    }
}
