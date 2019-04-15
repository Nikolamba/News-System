package ru.job4j.news.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "comment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News forNews;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    public Comment() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setForNews(News forNews) {
        this.forNews = forNews;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public News getForNews() {
        return forNews;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
