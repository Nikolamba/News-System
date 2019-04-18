package ru.job4j.news.services;

import ru.job4j.news.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findByName(String name);
    Author save(Author author);
}
