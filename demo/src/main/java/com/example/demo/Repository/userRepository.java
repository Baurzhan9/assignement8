package com.example.demo.Repository;

import com.example.demo.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
    List<user> findAllByNameContainingAndSurname(String name, String surname);

}
