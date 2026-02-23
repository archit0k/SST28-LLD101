public class EmailTruncator extends NotificationSender {
    private final NotificationSender base;

    public EmailTruncator(NotificationSender base, AuditLog audit) { 
        super(audit); 
        this.base = base; 
    }

    @Override
    public void send(Notification n) {
        String body = n.body;
        if (body.length() > 40) body = body.substring(0, 40);
        
        base.send(new Notification(n.subject, body, n.email, n.phone));
    }
}