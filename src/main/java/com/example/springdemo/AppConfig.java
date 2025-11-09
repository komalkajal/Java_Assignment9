package com.example.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("Spring and Hibernate");
    }

    @Bean
    public Student student() {
        // Dependency Injection — Course bean automatically injected
        return new Student(course());
    }
}
