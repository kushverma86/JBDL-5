package com.gfg.JDBL5.mongoDB;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    private String name;
    private String authorName;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
