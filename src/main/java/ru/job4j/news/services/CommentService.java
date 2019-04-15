package ru.job4j.news.services;

import ru.job4j.news.models.Comment;

import java.util.List;

public interface CommentService {
    Comment findById(int id);
    List<Comment> findByNews(int newsId);
    void save(Comment comment);
    void delete(Comment comment);
}
