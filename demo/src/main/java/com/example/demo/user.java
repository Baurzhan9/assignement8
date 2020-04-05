package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class user{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Request> requests;

    public user(){}
    public user( String name, String surname, String password, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", requests=" + requests +
                '}';
    }
}
