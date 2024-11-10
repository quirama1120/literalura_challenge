package com.alura.literatura_challenge.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksData(
        Long id,
        String title,
        String firstAuthorName,
        String language,
        Integer download_count) {
}
