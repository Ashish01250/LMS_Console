package com.library.model;

public abstract class Member extends User {

    private final int borrowingLimit;

    public Member(String userId, String name,
                  String email, int borrowingLimit) {

        super(userId, name, email);
        this.borrowingLimit = borrowingLimit;
    }

    public int getBorrowingLimit() {
        return borrowingLimit;
    }
}