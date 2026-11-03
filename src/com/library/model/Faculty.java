package com.library.model;

public class Faculty extends Member {

    public Faculty(String userId, String name, String email) {

        super(userId, name, email, 5);
    }

    @Override
    public void displayDashboard() {

        System.out.println("Faculty Dashboard");
        System.out.println("Name: " + getName());
        System.out.println("Borrowing Limit: " + getBorrowingLimit());
    }
}