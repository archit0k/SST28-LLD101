package strategy.pricing;

import model.ShowSeat;

public interface PricingStrategy {
    double calculatePrice(ShowSeat seat);
}
