package com.example.reports;

public class ReportProxy implements Report {

    private final String id;
    private final String title;
    private final String cls;
    private final AccessControl ac = new AccessControl();
    private RealReport real;

    public ReportProxy(String id, String title, String cls) {
        this.id = id;
        this.title = title;
        this.cls = cls;
    }

    @Override
    public void display(User u) {
        if (!ac.canAccess(u, cls)) {
            System.out.println("ACCESS DENIED: " + u.getName() + " does not have permission.");
            return;
        }
        
        if (real == null) {
            real = new RealReport(id, title, cls);
        }
        
        real.display(u);
    }
}