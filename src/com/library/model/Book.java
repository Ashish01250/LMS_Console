
package com.library.model;

public class Book {

    // 1. Properties (Encapsulation)
    private final String isbn;
    private String title;
    private String author;
    private String category;

    // 2. Constructor
    public Book(String isbn, String title,
                String author, String category) {

        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }

        this.isbn = isbn;
        setTitle(title);
        setAuthor(author);
        setCategory(category);
    }

    // 3. Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    // 4. Setters
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    public void setCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = category;
    }

    // 5. Display book details
    @Override
    public String toString() {
        return "ISBN: " + isbn +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nCategory: " + category;
    }
}
