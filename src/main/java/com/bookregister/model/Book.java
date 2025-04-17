package com.bookregister.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String readingStartDate;
    private String readingEndDate;
    private String bookTitle;
    private List<String> authors;
    private String bookSubject;
    private String area;
    private String bookSummary;
    private int yearOfPublication;
}