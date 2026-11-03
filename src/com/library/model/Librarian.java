
package com.library.model;

public class Librarian extends User {

    private final String employeeId;

    public Librarian(
            String userId,
            String name,
            String email,
            String employeeId) {

        super(userId, name, email);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public void displayDashboard() {

        System.out.println("===== LIBRARIAN DASHBOARD =====");
        System.out.println("Name: " + getName());
        System.out.println("Employee ID: " + employeeId);

        System.out.println("1. Manage Books");
        System.out.println("2. Manage Members");
        System.out.println("3. Issue Books");
        System.out.println("4. Return Books");
    }
}
