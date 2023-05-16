package com.softusing.hejunjie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id //主键/唯一性(不能重复,重名)
    @GeneratedValue(strategy = GenerationType.AUTO) //自增
    private long id;
    private String name;
    private String author;
    private int status;
    private String description;



    public Book() {
    }

    public Book(String name, String author, int status, String description) {
        this.name = name;
        this.author = author;
        this.status = status;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
