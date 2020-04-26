package com.example.demo.controllers;

import com.example.demo.Entity.Books;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Api(value = "Book Controller class", description = "Book object")
public class BooksController {

    @Autowired
    private com.example.demo.Repository.BooksRepository BooksRepository;

    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Books> getAllbooks(){
        return BooksRepository.findAll();
    }

    @GetMapping("/{id}")
    public Books getBooksById(@PathVariable Long id){
        return BooksRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<Books> getByNameContainingAndSurname(@RequestParam String name){
        return BooksRepository.findAllByNameContaining(name);
    }

    @PostMapping("")
    public  Books createBooks(@RequestBody Books Books){
        return BooksRepository.saveAndFlush(Books);
    }

    @PutMapping("/{id}")
    public  Books updateBook(@PathVariable Long id,
                            @RequestBody Books Books) {
        Books.setId(id);
        return BooksRepository.saveAndFlush(Books);
    }

    @PatchMapping("/{id}")
    public Books updateUserAge(@PathVariable Long id,
                              @RequestParam String name){
        Books books = BooksRepository.findById(id).get();
        books.getName(name);
        return BooksRepository.saveAndFlush(books);
    }
}
