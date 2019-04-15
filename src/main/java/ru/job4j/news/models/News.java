package ru.job4j.news.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "news")
public class News {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "news_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "forNews")
    private List<Comment> comments;

    @Column(name = "date")
    private Date date;

    public News() {}

    public Author getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(text, news.text) &&
                Objects.equals(date, news.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, text, date);
    }
}
