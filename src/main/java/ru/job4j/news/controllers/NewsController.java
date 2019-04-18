package ru.job4j.news.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.news.models.Author;
import ru.job4j.news.models.News;
import ru.job4j.news.services.AuthorService;
import ru.job4j.news.services.NewsService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/index/{num}")
    public String showAllNews(@PathVariable Integer num,  Model model) {
        List<News> listNewsForPage = newsService.findPageNews(num);
        List<Integer> pageCount = new ArrayList<>();
        for (int i = 0; i < (newsService.countAllNews() / 5) + 1; i++) {
            pageCount.add(i + 1);
        }
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("news", listNewsForPage);
        model.addAttribute("currentPage", num);
        return "news";
    }

    @GetMapping("/{num}")
    public String showMoreInfoAboutNews() {
        return "news_info";
    }

    @GetMapping("/index")
    public String showFirstNewsPage(Model model) {
        return "redirect:/index/1";
    }

    @PostMapping("/addnews")
    public String addNews(@ModelAttribute News news, @RequestParam String author) {
        Author newsAuthor = authorService.findByName(author);
        newsAuthor = (newsAuthor == null) ? authorService.save(new Author(author)) : newsAuthor;
        news.setAuthor(newsAuthor);
        news.setComments(new ArrayList<>());
        newsService.save(news);
        return "redirect:/index";
    }

    @GetMapping("/more/{num}")
    public String showNewsWithComments() {
        return "news_with_comments";
    }
}
