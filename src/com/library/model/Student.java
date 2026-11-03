package com.library.model;

public class Student extends Member {

    public Student(String userId, String name, String email) {

        super(userId, name, email, 3);
    }

    @Override
    public void displayDashboard() {

        System.out.println("Student Dashboard");
        System.out.println("Name: " + getName());
        System.out.println("Borrowing Limit: " + getBorrowingLimit());
    }
}