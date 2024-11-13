package com.alura.literatura_challenge.main.logical;
import com.alura.literatura_challenge.model.ApiResponse;
import com.alura.literatura_challenge.model.Author;
import com.alura.literatura_challenge.model.Book;
import com.alura.literatura_challenge.repository.AuthorRepository;
import com.alura.literatura_challenge.repository.BooksRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConsultingBooks {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BooksRepository booksRepository;
    @Transactional
        public List<Book> consultingData () {
            try {
                Scanner keyword = new Scanner(System.in);
            final String URL_BASE = "https://gutendex.com/books?search=";
            System.out.println("Ingresa el nombre del libro que deseas consultar");
            String userBookConsulting = keyword.nextLine();
            String bookNameToConsult = userBookConsulting.replaceAll(" ", "+");
            String url = URL_BASE + bookNameToConsult;
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse response = mapper.readValue(new URL(url), ApiResponse.class);


        response.getResults().forEach(book -> {
            System.out.println("ID: " + book.getId());
            System.out.println("Título: " + book.getTitle());
            System.out.println("Autores: " + book.getAuthors().get(0).getName());
            System.out.println("Idiomas: " + String.join(", ", book.getLanguages()));
            System.out.println("Descargas: " + book.getDownload_count());
            System.out.println("------------");

        });

                return response.getResults().stream().map(e -> {
                    Author author = new Author();
                    author.setName(e.getAuthors().get(0).getName());
                    author.setBirth_year(e.getAuthors().get(0).getBirth_year());
                    author.setDeath_year(e.getAuthors().get(0).getDeath_year());

                    Optional<Author> existingAuthor = authorRepository.findByName(author.getName());

                    if (existingAuthor.isPresent()) {
                        author = existingAuthor.get();
                    } else {
                        author = authorRepository.saveAndFlush(author);
                    }
                    List<Author> authorsList = new ArrayList<>(Collections.singletonList(author));
                    Book book = new Book();
                    book.setTitle(e.getTitle());
                    book.setLanguages(e.getLanguages());
                    book.setDownload_count(e.getDownload_count());

                    Optional<Book> existingBook = booksRepository.findByTitle(book.getTitle());

                    if (existingBook.isPresent()) {
                        book = existingBook.get();
                        book.setAuthors(existingBook.get().getAuthors());
                        book.setLanguages(e.getLanguages());
                        book.setDownload_count(e.getDownload_count());
                    } else {
                        book.setAuthors(authorsList);
                    }
                    book = booksRepository.saveAndFlush(book);

                    return book;
                }).collect(Collectors.toList());
    } catch (IOException e) {
                System.out.println("Se ha presentado el siguiente error " + e);
    }
            return null;
        }
}


