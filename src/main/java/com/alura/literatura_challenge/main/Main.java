package com.alura.literatura_challenge.main;
import com.alura.literatura_challenge.main.logical.ConsultingBooks;
import com.alura.literatura_challenge.model.Author;
import com.alura.literatura_challenge.model.Book;
import com.alura.literatura_challenge.repository.AuthorRepository;
import com.alura.literatura_challenge.service.AuthorsInDataBase;
import com.alura.literatura_challenge.service.BooksInDatabase;
import com.alura.literatura_challenge.service.DataConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Main {
    @Autowired
    ConsultingBooks consultingBooks;
    @Autowired
    BooksInDatabase booksInDatabase;
    @Autowired
    AuthorsInDataBase authorsInDataBase;
DataConversor converse = new DataConversor();
Book book = new Book();
    public void mainCall() {

        Scanner keyword = new Scanner(System.in);
        boolean out = true;
        while (out) {
            System.out.println("""
					Ingresa la opción que desees consultar
					1. Consultar libro por título.
					2. Listar libros registrados.
					3. Consultar autores registrados.
					4. Consultar autores vivos en un determinado año.
					5. Listar libros por idioma.
					0. Salir.
					""");
            int userInput = keyword.nextInt();
            switch (userInput) {
                case 1 -> consultingBooks.consultingData();
                case 2 -> booksInDatabase.booksInDatabaseSearch();
                case 3 -> authorsInDataBase.authorsInDatabase();
                case 4 -> authorsInDataBase.livingAuthorsOnDate();
                case 5 -> booksInDatabase.displayBooksByLanguage();
                case 0 -> {
                    System.out.println("Finalizando el programa...");
                    out = false;
                } default -> System.out.println("Has ingresado la opción incorrecta.");

            }
        }
    }
}
