package com.example.reports;

public class RealReport implements Report {

    private final String id;
    private final String title;
    private final String cls;
    private final String body;

    public RealReport(String id, String title, String cls) {
        this.id = id;
        this.title = title;
        this.cls = cls;
        this.body = load(); 
    }

    @Override
    public void display(User u) {
        System.out.println("REPORT -> id=" + id + " title=" + title + " classification=" + cls + " openedBy=" + u.getName());
        System.out.println("CONTENT: " + body); 
    }

    private String load() {
        System.out.println("[disk] loading report " + id + " ...");
        try { Thread.sleep(120); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return "Internal report body for " + title;
    }
}