package strategy.pricing;

import model.ShowSeat;

public class SurgePricing implements PricingStrategy {
    public double calculatePrice(ShowSeat seat) {
        return seat.getBasePrice() * 1.5;
    }
}
