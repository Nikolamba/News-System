package ru.job4j.news.services;

import ru.job4j.news.models.Comment;
import ru.job4j.news.models.News;

import java.util.List;

public interface NewsService {
    List<News> findAll();
    void save(News news);
    News findById(int id);
    List<News> findPageNews(int pageNum);
    Long countAllNews();
    void addComment(Comment comment, Integer newsId);
}
