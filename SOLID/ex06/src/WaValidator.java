public class WaValidator extends NotificationSender {
    private final NotificationSender base;

    public WaValidator(NotificationSender base, AuditLog audit) {
        super(audit);
        this.base = base;
    }

    @Override
    public void send(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            throw new IllegalArgumentException("phone must start with + and country code");
        }

        base.send(n);
    }
}