package com.example.payments;

public class OrderService {
    
    private final PaymentGateway gw;

    public OrderService(PaymentGateway gw) {
        if (gw == null) throw new IllegalArgumentException("gateway needed");
        this.gw = gw;
    }

    public String charge(String cid, int amt) {
        return gw.charge(cid, amt);
    }
}