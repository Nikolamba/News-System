package ru.job4j.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.news.models.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentByForNews_Id(int newsId);
}
