package com.bookregister.graphql;

import com.bookregister.model.Book;
import com.bookregister.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book getBookById(@Argument String id) {
        return bookService.getBookById(id).orElse(null);
    }

    @QueryMapping
    public List<Book> getBooksByTitle(@Argument String bookTitle) {
        return bookService.getBooksByTitle(bookTitle);
    }

    @MutationMapping
    public Book createBook(@Argument BookInput bookInput) {
        Book book = new Book();
        book.setReadingStartDate(bookInput.readingStartDate());
        book.setReadingEndDate(bookInput.readingEndDate());
        book.setBookTitle(bookInput.bookTitle());
        book.setAuthors(bookInput.authors());
        book.setBookSubject(bookInput.bookSubject());
        book.setArea(bookInput.area());
        book.setBookSummary(bookInput.bookSummary());
        book.setYearOfPublication(bookInput.yearOfPublication());
        book.setTimesRead(bookInput.timesRead());
        return bookService.createBook(book);
    }

    @MutationMapping
    public Book updateBook(@Argument String id, @Argument BookInput bookInput) {
        Book book = new Book();
        book.setReadingStartDate(bookInput.readingStartDate());
        book.setReadingEndDate(bookInput.readingEndDate());
        book.setBookTitle(bookInput.bookTitle());
        book.setAuthors(bookInput.authors());
        book.setBookSubject(bookInput.bookSubject());
        book.setArea(bookInput.area());
        book.setBookSummary(bookInput.bookSummary());
        book.setYearOfPublication(bookInput.yearOfPublication());
        book.setTimesRead(bookInput.timesRead());
        return bookService.updateBook(id, book).orElse(null);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument String id) {
        return bookService.deleteBook(id);
    }

    // Record to map GraphQL BookInput
    public record BookInput(
            String readingStartDate,
            String readingEndDate,
            String bookTitle,
            List<String> authors,
            String bookSubject,
            String area,
            String bookSummary,
            int yearOfPublication,
            int timesRead
    ) {
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Application is running!";
    }
}