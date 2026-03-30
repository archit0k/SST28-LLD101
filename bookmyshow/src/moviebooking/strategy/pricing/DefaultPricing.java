package strategy.pricing;

import model.ShowSeat;

public class DefaultPricing implements PricingStrategy {
    public double calculatePrice(ShowSeat seat) {
        return seat.getBasePrice();
    }
}
