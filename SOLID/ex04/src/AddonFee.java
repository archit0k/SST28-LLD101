import java.util.Map;

public class AddonFee implements Fee {
    private final Map<AddOn, Double> rates;

    public AddonFee(Map<AddOn, Double> rates) {
        this.rates = rates;
    }

    @Override
    public double calc(BookingRequest req) {
        double tot = 0.0;
        for (AddOn a : req.addOns) {
            tot += rates.getOrDefault(a, 0.0);
        }
        return tot;
    }
}