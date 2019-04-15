package ru.job4j.news.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "author_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
