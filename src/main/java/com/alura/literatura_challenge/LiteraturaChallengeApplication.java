package com.alura.literatura_challenge;

import com.alura.literatura_challenge.main.Main;
import com.alura.literatura_challenge.main.logical.ConsultingBooks;
import com.alura.literatura_challenge.repository.AuthorRepository;
import com.alura.literatura_challenge.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaChallengeApplication implements CommandLineRunner {
	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private Main main;
	public static void main(String[] args) {
		SpringApplication.run(LiteraturaChallengeApplication.class, args);
	}

	public void run(String... args) {
		main.mainCall();
	}

}

