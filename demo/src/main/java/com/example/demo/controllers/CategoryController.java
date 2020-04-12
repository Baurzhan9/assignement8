package com.example.demo.controllers;


import com.example.demo.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private com.example.demo.Repository.CategoryRepository CategoryRepository;

    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Category> getAllCategories(){
        return CategoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return CategoryRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<Category> getByCategoryRepositoryContaining(@RequestParam String Category){
        return CategoryRepository.findAllByCategoryContaining(Category);
    }

    @PostMapping("")
    public  Category createUser(@RequestBody Category Category){
        return CategoryRepository.saveAndFlush(Category);
    }

    @PutMapping("/{id}")
    public  Category updateUser(@PathVariable Long id,
                            @RequestBody Category Category) {
        Category.setId(id);
        return CategoryRepository.saveAndFlush(Category);
    }

    @PatchMapping("/{id}")
    public Category updateUserAge(@PathVariable Long id,
                              @RequestParam String category){
        Category cat = CategoryRepository.findById(id).get();
        cat.setCategory(category);
        return CategoryRepository.saveAndFlush(cat);
    }
}
