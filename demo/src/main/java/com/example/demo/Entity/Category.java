package com.example.demo.Entity;

import com.example.demo.Entity.Books;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;

    @ManyToMany(mappedBy = "category")
    private List<Books> book;


    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    @Override
    public String toString() {
        return "Category{" +
                "Category='" + category + '\'' +
                '}';
    }
}
