package ru.job4j.news.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.news.models.Comment;
import ru.job4j.news.repositories.CommentRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findByNews(int newsId) {
        return commentRepository.findCommentByForNews_Id(newsId);
    }

    @Override
    @Transactional
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }
}
