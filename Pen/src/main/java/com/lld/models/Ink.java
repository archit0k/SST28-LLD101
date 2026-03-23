package com.lld.models;

import com.lld.enums.Color;

public class Ink {
    private Color color;
    private int level; // 0 to 100

    public Ink(Color color) {
        this.color = color;
        this.level = 100;
    }

    public Color getColor() {
        return color;
    }

    public int getLevel() {
        return level;
    }

    public void reduceLevel(int amount) {
        this.level = Math.max(0, this.level - amount);
    }

    public void refillToMax() {
        this.level = 100;
    }
}
