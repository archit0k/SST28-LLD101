import java.util.List;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<Fee> fees;

    public HostelFeeCalculator(FakeBookingRepo repo, List<Fee> fees) {
        this.repo = repo;
        this.fees = fees;
    }

    public void process(BookingRequest req) {
        double tot = 0;
        for (Fee f : fees) {
            tot += f.calc(req);
        }

        Money monthly = new Money(tot);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String id = "H-" + (7000 + new java.util.Random(1).nextInt(1000));
        repo.save(id, req, monthly, deposit);
    }
}