package ru.job4j.news.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.news.models.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    Page<News> findAll(Pageable pageable);
}
