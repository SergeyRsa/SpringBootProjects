package com.in28minutes.springboot.rest.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private int price;

    protected Books() {}

    public Books(String name, String author,int price) 
    {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Books[id=%d, name='%s', author='%s', price=%d]",
                id, name, author,price);
    }

}