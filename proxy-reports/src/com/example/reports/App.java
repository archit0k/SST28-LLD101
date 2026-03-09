package com.example.reports;

public class App {

    public static void main(String[] args) {
        User s = new User("Jasleen", "STUDENT");
        User f = new User("Prof. Noor", "FACULTY");
        User a = new User("Kshitij", "ADMIN");

        Report pub = new ReportProxy("R-101", "Orientation Plan", "PUBLIC");
        Report fac = new ReportProxy("R-202", "Midterm Review", "FACULTY");
        Report adm = new ReportProxy("R-303", "Budget Audit", "ADMIN");

        ReportViewer v = new ReportViewer();

        System.out.println("=== CampusVault Demo ===");

        v.open(pub, s);
        System.out.println();

        v.open(fac, s); // Will hit ACCESS DENIED
        System.out.println();

        v.open(fac, f); // Loads from disk
        System.out.println();

        v.open(adm, a); // Loads from disk
        System.out.println();

        v.open(adm, a); // Instant load (hits cache, skips disk)
    }
}