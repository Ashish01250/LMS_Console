package com.library.service;
import java.util.List;
import com.library.repository.BookRepository;
import com.library.model.Book;

public class BookService {

    private final BookRepository bookRepository;

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add Book
    public void addBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        bookRepository.addBook(book);
    }

    // Search book using ISBN
    public Book getBookByISBN(String isbn) {
        return bookRepository.searchById(isbn);
    }

    // Search books using keyword
    public List<Book> searchBooks(String keyword) {
        return bookRepository.searchByKeyword(keyword);
    }


    // Update book details
    public void updateBook(
            String isbn,
            String newTitle,
            String newAuthor,
            String newCategory) {

        // Find existing book
        Book book = bookRepository.searchById(isbn);

        // Update its details
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setCategory(newCategory);
    }

    // Delete book
    public void deleteBook(String isbn) {
        bookRepository.deleteBook(isbn);
    }
}