
package com.library.model;

import com.library.enums.BookStatus;

public class BookCopy {

    // Properties
    private final String copyId;
    private final Book book;
    private BookStatus status;

    // Constructor
    public BookCopy(String copyId, Book book) {

        if (copyId == null || copyId.isBlank()) {
            throw new IllegalArgumentException(
                    "Copy ID cannot be empty"
            );
        }

        if (book == null) {
            throw new IllegalArgumentException(
                    "Book cannot be null"
            );
        }

        this.copyId = copyId;
        this.book = book;
        this.status = BookStatus.AVAILABLE;
    }

    // Getters
    public String getCopyId() {
        return copyId;
    }

    public Book getBook() {
        return book;
    }

    public BookStatus getStatus() {
        return status;
    }

    // Issue a book copy
    public void issue() {

        if (status != BookStatus.AVAILABLE) {
            throw new IllegalStateException(
                    "Book copy is not available"
            );
        }

        status = BookStatus.ISSUED;
    }

    // Return a book copy
    public void returnBook() {

        if (status != BookStatus.ISSUED) {
            throw new IllegalStateException(
                    "This book copy was not issued"
            );
        }

        status = BookStatus.AVAILABLE;
    }

    // Display details
    @Override
    public String toString() {

        return "Copy ID: " + copyId +
                "\nBook: " + book.getTitle() +
                "\nStatus: " + status;
    }
}
