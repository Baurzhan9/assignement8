package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        userRepository userRepo = context.getBean("userRepository", userRepository.class);
        System.out.println(userRepo.findAll());

    }

}
