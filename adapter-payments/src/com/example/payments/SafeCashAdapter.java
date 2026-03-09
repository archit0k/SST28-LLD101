package com.example.payments;

public class SafeCashAdapter implements PaymentGateway {
    
    private final SafeCashClient cli;
    
    public SafeCashAdapter(SafeCashClient cli) {
        this.cli = cli;
    }

    @Override
    public String charge(String cid, int amt) {
        SafeCashPayment p = cli.createPayment(amt, cid);
        return p.confirm();
    }
}