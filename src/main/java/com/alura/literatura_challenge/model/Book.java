package com.alura.literatura_challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "books")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_languages", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "language")
    private List<String> languages = new ArrayList<>();

    private Integer download_count;

    public Book() {}

    public Book(Long id, String title, List<Author> authors, List<String> languages, Integer download_count) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.download_count = download_count;
    }

    public Book(List<Book> bookInformation) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }
    public Author getMainAuthor() {
        return (authors != null && !authors.isEmpty()) ? authors.get(0) : null;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", languages=" + languages +
                ", download_count=" + download_count;
    }
}
