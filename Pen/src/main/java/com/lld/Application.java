package com.lld;

import com.lld.factory.PenFactory;
import com.lld.enums.PenType;
import com.lld.enums.Color;
import com.lld.interfaces.Pen;
import com.lld.interfaces.Refillable;

public class Application {
    public static void main(String[] args) {

        Pen pen = PenFactory.getPen(PenType.GEL_PEN, Color.BLUE, true);

        try {
            pen.start();
            pen.write("SOLID Design is awesome");
            pen.close();

            if (pen instanceof Refillable) {
                ((Refillable) pen).refill();
            }

        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}