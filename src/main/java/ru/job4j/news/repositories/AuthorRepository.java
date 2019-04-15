package ru.job4j.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.news.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByName(String name);
}
