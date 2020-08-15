package com.gfg.JDBL5.mongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Integer> {
    public Book findByName(String name);

    public List<Book> findByAuthorName(String authorName);
}
