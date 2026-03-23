package com.lld.models;

import com.lld.enums.Color;
import com.lld.interfaces.Pen;
import com.lld.interfaces.Refillable;

public abstract class BasePen implements Pen, Refillable {
    protected Ink ink;
    protected boolean hasCap;
    protected boolean isOpen;

    public BasePen(Color color, boolean hasCap) {
        this.ink = new Ink(color);
        this.hasCap = hasCap;
        this.isOpen = !hasCap;
    }

    @Override
    public void start() {
        if (!isOpen) {
            isOpen = true;
            System.out.println(this.getClass().getSimpleName() + " is ready.");
        }
    }

    @Override
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println(this.getClass().getSimpleName() + " is closed.");
        }
    }

    @Override
    public void write(String text) {
        if (!isOpen) {
            throw new IllegalStateException("Cannot write. Start the pen first.");
        }
        if (ink.getLevel() <= 0) {
            System.out.println("Out of ink!");
            return;
        }

        System.out.println("Writing [" + text + "] in " + ink.getColor());
        ink.reduceLevel(10); // Assume each write consumes 10% ink
        System.out.println("Ink remaining: " + ink.getLevel() + "%");
    }

    @Override
    public void refill() {
        ink.refillToMax();
        System.out.println(this.getClass().getSimpleName() + " refilled to 100%.");
    }
}
