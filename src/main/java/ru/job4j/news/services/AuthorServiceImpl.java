package ru.job4j.news.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.news.models.Author;
import ru.job4j.news.repositories.AuthorRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }
}
