package com.gfg.JDBL5.mongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return service.getBooks();
    }

    @GetMapping("/book/{name}")
    public Book getBookByName(@PathVariable String name){
        return service.getBookName(name);
    }

    @GetMapping("/book")
    public List<Book> getBookByAuthorName(@RequestParam(value = "author_name") String author_name){
        return service.getBookByAuthorName(author_name);
    }

    @PostMapping("/insert")
    public Book insertBook(@RequestBody Book book){
        return service.insert(book);
    }

    @PostMapping("/bulk/insert")
    public long bulkInsert(@RequestBody List<Book> books){
        return service.insertBulk(books);
    }

    @PostMapping("/bulk/insert2")
    public long bulkInsert2(@RequestBody List<Book> books){
        return service.insertBulkMultiThread(books);
    }

}
