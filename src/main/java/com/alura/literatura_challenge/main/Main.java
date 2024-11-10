package com.alura.literatura_challenge.main;
import com.alura.literatura_challenge.main.logical.ConsultingBooks;
import com.alura.literatura_challenge.model.Book;
import com.alura.literatura_challenge.model.BooksData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
public class Main {
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
                case 1 -> {
                    ConsultingBooks consultingBooks = new ConsultingBooks();
                    consultingBooks.consultingData();


                } case 2 -> {
                    System.out.println("por ahora éste es el caso 2");
                } case 0 -> {
                    System.out.println("Finalizando el programa...");
                    out = false;
                }
            }
        }
    }
}
