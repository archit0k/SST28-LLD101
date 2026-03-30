package strategy.payment;

public class UpiPayment implements PaymentStrategy {
    public boolean pay(double amount) {
        return true;
    }
}
