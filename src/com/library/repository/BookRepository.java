
package com.library.repository;
import java.util.Locale;
import com.library.exception.BookNotFoundException;
import com.library.interfaces.Searchable;
import com.library.model.Book;
import com.library.exception.DuplicateBookException;

import java.util.*;

public class BookRepository implements Searchable<Book> {

    // ISBN is the key and Book is the value
    private final Map<String, Book> books = new HashMap<>();

    // Add a book
    public void addBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        String isbn = book.getIsbn();

        if (books.containsKey(isbn)) {
            throw new DuplicateBookException(
                    "Book already exists with ISBN: " + isbn
            );
        }

        books.put(isbn, book);


    }

    // Search by ISBN
    @Override
    public Book searchById(String isbn) {

        Book book = books.get(isbn);

        if (book == null) {
            throw new BookNotFoundException(
                    "Book not found with ISBN: " + isbn
            );
        }

        return book;
    }

    // Search by title, author or category
    @Override
    public List<Book> searchByKeyword(String keyword) {

        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException(
                    "Search keyword cannot be empty"
            );
        }

        String search = keyword.trim().toLowerCase(Locale.ROOT);

        List<Book> results = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getTitle().toLowerCase().contains(search)
                    || book.getAuthor().toLowerCase().contains(search)
                    || book.getCategory().toLowerCase().contains(search)) {

                results.add(book);
            }
        }

        return results;
    }

    // Display all books
    public List<Book> findAll() {

        return new ArrayList<>(books.values());
    }

    // Delete a book
    public void deleteBook(String isbn) {

        if (!books.containsKey(isbn)) {
            throw new BookNotFoundException(
                    "Cannot delete! Book not found: " + isbn
            );
        }

        books.remove(isbn);


    }

    // Total number of books in catalog
    public int countBooks() {

        return books.size();
    }
}
