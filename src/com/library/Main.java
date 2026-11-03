package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import com.library.exception.DuplicateBookException;
import com.library.exception.BookNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookRepository repository = new BookRepository();
        BookService bookService = new BookService(repository);

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by ISBN");
            System.out.println("3. Search Books by Keyword");
            System.out.println("4. View All Books");
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. View Total Books");
            System.out.println("0. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                System.out.println("\n--- ADD NEW BOOK ---");

                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();

                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();

                System.out.print("Enter Author Name: ");
                String author = scanner.nextLine();

                System.out.print("Enter Category: ");
                String category = scanner.nextLine();

                try {
                    Book book = new Book(isbn, title, author, category);

                    bookService.addBook(book);

                    System.out.println("Book added successfully!");

                } catch (DuplicateBookException e) {
                    System.out.println("Error: " + e.getMessage());

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                break;

                case 2:
                    System.out.println("\n--- SEARCH BOOK BY ISBN ---");

                    System.out.print("Enter ISBN: ");
                    String searchIsbn = scanner.nextLine();

                    try {
                        Book book = bookService.getBookByISBN(searchIsbn);

                        System.out.println("\nBook Found!");
                        System.out.println(book);

                    } catch (BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 3:
                    System.out.println("\n--- SEARCH BOOKS BY KEYWORD ---");

                    System.out.print("Enter title, author or category: ");
                    String keyword = scanner.nextLine();

                    try {

                        List<Book> results =
                                bookService.searchBooks(keyword);

                        if (results.isEmpty()) {

                            System.out.println("No books found!");

                        } else {

                            System.out.println("\nSearch Results:");

                            for (Book book : results) {
                                System.out.println("--------------------");
                                System.out.println(book);
                            }
                        }

                    } catch (IllegalArgumentException e) {

                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\n--- ALL BOOKS ---");

                    List<Book> allBooks = bookService.getAllBooks();

                    if (allBooks.isEmpty()) {

                        System.out.println("No books available!");

                    } else {

                        for (Book book : allBooks) {
                            System.out.println("--------------------");
                            System.out.println(book);
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--- UPDATE BOOK ---");

                    System.out.print("Enter ISBN of book to update: ");
                    String updateIsbn = scanner.nextLine();

                    try {

                        // First check whether the book exists
                        Book existingBook =
                                bookService.getBookByISBN(updateIsbn);

                        System.out.println("\nCurrent Book Details:");
                        System.out.println(existingBook);

                        System.out.print("\nEnter New Title: ");
                        String newTitle = scanner.nextLine();

                        System.out.print("Enter New Author: ");
                        String newAuthor = scanner.nextLine();

                        System.out.print("Enter New Category: ");
                        String newCategory = scanner.nextLine();

                        bookService.updateBook(
                                updateIsbn,
                                newTitle,
                                newAuthor,
                                newCategory
                        );

                        System.out.println("Book updated successfully!");

                    } catch (BookNotFoundException |
                             IllegalArgumentException e) {

                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 6:
                    System.out.println("\n--- DELETE BOOK ---");

                    System.out.print("Enter ISBN of book to delete: ");
                    String deleteIsbn = scanner.nextLine();

                    try {

                        Book book = bookService.getBookByISBN(deleteIsbn);

                        System.out.println("\nBook Details:");
                        System.out.println(book);

                        System.out.print(
                                "\nAre you sure you want to delete? (Y/N): "
                        );

                        String confirmation = scanner.nextLine();

                        if (confirmation.equalsIgnoreCase("Y")) {

                            bookService.deleteBook(deleteIsbn);

                            System.out.println("Book deleted successfully!");

                        } else {

                            System.out.println("Deletion cancelled.");
                        }

                    } catch (BookNotFoundException e) {

                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("\n--- TOTAL BOOKS ---");

                    System.out.println(
                            "Total Books: " +
                                    bookService.getAllBooks().size()
                    );
                    break;

                case 0:
                    System.out.println(
                            "\nThank you for using our Library!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}