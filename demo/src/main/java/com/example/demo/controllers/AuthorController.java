package com.example.demo.controllers;


import com.example.demo.Entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private com.example.demo.Repository.AuthorRepository AuthorRepository;

    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Author> getAllAuthors(){
        return AuthorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Integer id){
        return AuthorRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<Author> getByNameContaining(@RequestParam String name){
        return AuthorRepository.findAllByNameContaining(name);
    }

    @PostMapping("")
    public  Author createAuthor(@RequestBody Author Author){
        return AuthorRepository.saveAndFlush(Author);
    }

    @PutMapping("/{id}")
    public  Author updateAuthor(@PathVariable Integer id,
                            @RequestBody Author Author) {
        Author.setId(id);
        return AuthorRepository.saveAndFlush(Author);
    }

    @PatchMapping("/{id}")
    public Author updateUserAge(@PathVariable Integer id,
                              @RequestParam String name){
        Author Author = AuthorRepository.findById(id).get();
        Author.setName(name);
        return AuthorRepository.saveAndFlush(Author);
    }
}
