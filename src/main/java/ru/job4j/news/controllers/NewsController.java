package ru.job4j.news.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/index")
    public String showFirstNewsPage(Model model) {
        return "redirect:/index/1";
    }

    @GetMapping("/addnews")
    public String showAddNewsPage(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("news", new News());
        return "addnews.jsp";
    }

    @PostMapping("/addnews")
    public String addNews(@ModelAttribute News news) {
        Author author = authorService.findByName(news.getAuthor().getName());
        news.setAuthor(author);
        news.setComments(new ArrayList<>());
        news.setDate(new Date(System.currentTimeMillis()));
        newsService.save(news);
        return "redirect:/news.do";
    }

    @GetMapping("/editnews.do/{newsId}")
    public String editNews(@PathVariable Integer newsId, Model model) {
        model.addAttribute("news", newsService.findById(newsId));
        return "editnews.jsp";
    }

    @PostMapping("/editnews")
    public String editNewsPost(@ModelAttribute News news) {
        News news1 = newsService.findById(news.getId());
        news1.setText(news.getText());
        newsService.save(news1);
        return "redirect:news.do";
    }
}
