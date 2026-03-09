package com.example.payments;

import java.util.HashMap;
import java.util.Map;

public class App {
    
    public static void main(String[] args) {
        Map<String, PaymentGateway> gws = new HashMap<>();
        
        gws.put("fastpay", new FastPayAdapter(new FastPayClient()));
        gws.put("safecash", new SafeCashAdapter(new SafeCashClient()));

        OrderService s1 = new OrderService(gws.get("fastpay"));
        String id1 = s1.charge("cust-1", 1299);
        
        OrderService s2 = new OrderService(gws.get("safecash"));
        String id2 = s2.charge("cust-2", 1299);

        System.out.println(id1);
        System.out.println(id2);
    }
}