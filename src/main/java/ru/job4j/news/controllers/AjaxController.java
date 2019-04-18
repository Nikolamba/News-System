package ru.job4j.news.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.job4j.news.models.Comment;
import ru.job4j.news.models.News;
import ru.job4j.news.services.CommentService;
import ru.job4j.news.services.NewsService;

@Controller
public class AjaxController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/ajax/{num}")
    @ResponseBody
    public News getNewsInfo(@PathVariable Integer num) {
        News news = newsService.findById(num);
        return news;
    }

    @PostMapping("/addcomment")
    @ResponseBody
    public void addComment(@RequestParam String text,
                           @RequestParam Integer newsId) {
        Comment comment = new Comment(text);
        News news = new News();
        news.setId(newsId);
        comment.setForNews(news);
        commentService.save(comment);
    }
}
