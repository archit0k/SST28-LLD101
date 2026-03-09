package com.example.payments;

public class FastPayAdapter implements PaymentGateway {
    
    private final FastPayClient cli;
    
    public FastPayAdapter(FastPayClient cli) {
        this.cli = cli;
    }

    @Override
    public String charge(String cid, int amt) {
        return cli.payNow(cid, amt);
    }
}