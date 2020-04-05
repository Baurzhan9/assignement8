package com.example.demo;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date due_date;
    private Date return_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private user users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Books book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public user getUsers() {
        return users;
    }

    public void setUsers(user users) {
        this.users = users;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", due_date=" + due_date +
                ", return_date=" + return_date +
                ", book=" + book +
                '}';
    }
}
