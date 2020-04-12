package com.example.demo.Entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Transactional
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date date;
    private boolean available;

    @OneToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<Author> author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BookCategory",
        joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")}
    )
    private Set<Category> category;

    @ManyToMany(mappedBy = "books")
    private List<com.example.demo.Entity.user> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return this.name;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public Set<Category> getCategory() {
        return category;
    }



    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", available=" + available +
                ", author=" + author +
                ", category=" + category +
                '}';
    }
}
