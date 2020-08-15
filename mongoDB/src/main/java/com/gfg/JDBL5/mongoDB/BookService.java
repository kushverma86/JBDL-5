package com.gfg.JDBL5.mongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book insert(Book book){
       return bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBookName(String name){
        return bookRepository.findByName(name);
    }

    public long insertBulk(List<Book> books) {
        long tick = System.currentTimeMillis();

        try {
            bookRepository.saveAll(books);
        }catch (Exception e){
            bookRepository.deleteAll(books);
        }

        long tock = System.currentTimeMillis();

        return tock - tick;
    }

    public long insertBulkMultiThread(List<Book> books) {

        long tick = System.currentTimeMillis();

        try{
            Thread[] insertionThreads = new Thread[books.size()];
            int i = 0;
            for (Book book: books){
                insertionThreads[i] = new Thread(){
                    public void run(){
                        bookRepository.save(book);
                    }
                };

                insertionThreads[i].start();;
                i++;
            }

            for(i=0;i<insertionThreads.length;i++) {

                insertionThreads[i].join();
            }

        }
        catch (Exception e){
            bookRepository.deleteAll(books);
        }

        long tock = System.currentTimeMillis();

        return tock-tick;

    }

    public List<Book> getBookByAuthorName(String author_name) {

        return bookRepository.findByAuthorName(author_name);

    }
}
