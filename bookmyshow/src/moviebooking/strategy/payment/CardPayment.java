package strategy.payment;

public class CardPayment implements PaymentStrategy {
    public boolean pay(double amount) {
        return true;
    }
}
