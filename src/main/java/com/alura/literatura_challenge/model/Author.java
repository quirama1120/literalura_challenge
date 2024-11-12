package com.alura.literatura_challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer birth_year;
    private Integer death_year;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author() {}

    public Author(String name, Integer birth_year, Integer death_year) {
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }
    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", birth_year=" + birth_year +
                ", death_year=" + death_year;

    }
}
