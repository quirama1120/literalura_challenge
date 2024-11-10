package com.alura.literatura_challenge.main.logical;

import com.alura.literatura_challenge.model.ApiResponse;
import com.alura.literatura_challenge.model.Author;
import com.alura.literatura_challenge.model.Book;
import com.alura.literatura_challenge.model.BooksData;
import com.alura.literatura_challenge.service.ApiCall;
import com.alura.literatura_challenge.service.DataConversor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsultingBooks {

        public void consultingData () {
            try {
                Scanner keyword = new Scanner(System.in);
                ApiCall apiCall = new ApiCall();
            final String URL_BASE = "https://gutendex.com/books?search=";
            System.out.println("Ingresa el nombre del libro que deseas consultar");
            String userBookConsulting = keyword.nextLine();
            String bookNameToConsult = userBookConsulting.replaceAll(" ", "+");
            String url = URL_BASE + bookNameToConsult;
//        var apiResponse = apiCall.receivingData(url);
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse response = mapper.readValue(new URL(url), ApiResponse.class);


        response.getResults().forEach(book -> {
            System.out.println("ID: " + book.getId());
            System.out.println("Título: " + book.getTitle());
            System.out.println("Autores: " + book.getAuthors().stream().map(Author::getName).toList());
            System.out.println("Idiomas: " + String.join(", ", book.getLanguages()));
            System.out.println("Descargas: " + book.getDownload_count());
            System.out.println("------------");
        });
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}


