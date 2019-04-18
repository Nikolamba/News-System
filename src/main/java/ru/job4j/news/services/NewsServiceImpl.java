package ru.job4j.news.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.news.models.Comment;
import ru.job4j.news.models.News;
import ru.job4j.news.repositories.NewsRepository;

import javax.persistence.OneToMany;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    @Transactional
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public News findById(int id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    public List<News> findPageNews(int pageNum) {
        Pageable page = PageRequest.of(pageNum - 1, 5);
        Page<News> newsPage = newsRepository.findAll(page);
        return newsPage.getContent();
    }

    @Override
    public Long countAllNews() {
        Pageable page = PageRequest.of(0, Integer.MAX_VALUE);
        Page<News> newsPage = newsRepository.findAll(page);
        return newsPage.getTotalElements();
    }

    @Override
    @Transactional
    public void addComment(Comment comment, Integer newsId) {
        News news = newsRepository.findById(newsId).get();
        news.addComment(comment);
        newsRepository.save(news);
    }
}
