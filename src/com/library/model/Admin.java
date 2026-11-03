
package com.library.model;

public class Admin extends User {

    private final String adminLevel;

    public Admin(
            String userId,
            String name,
            String email,
            String adminLevel) {

        super(userId, name, email);
        this.adminLevel = adminLevel;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    @Override
    public void displayDashboard() {

        System.out.println("===== ADMIN DASHBOARD =====");
        System.out.println("Name: " + getName());
        System.out.println("Admin Level: " + adminLevel);

        System.out.println("1. Manage Librarians");
        System.out.println("2. Manage Library");
        System.out.println("3. View Reports");
        System.out.println("4. System Settings");
    }
}
