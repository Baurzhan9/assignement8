package com.example.demo.Repository;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByCategoryContaining(String Category);
}
