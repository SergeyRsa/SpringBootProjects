package com.in28minutes.springboot.rest.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepositroy extends CrudRepository<Books, Long> 
{
    List<Books> findByAuthor(String author);
}