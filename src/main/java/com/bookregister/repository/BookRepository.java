package com.bookregister.repository;

import com.bookregister.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByBookTitleContainingIgnoreCase(String bookTitle);
}