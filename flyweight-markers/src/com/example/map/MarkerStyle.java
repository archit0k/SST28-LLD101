package com.example.map;

public class MarkerStyle {

    private final String shape;   
    private final String color;   
    private final int size;       
    private final boolean filled; 

    public MarkerStyle(String s, String c, int sz, boolean f) {
        this.shape = s;
        this.color = c;
        this.size = sz;
        this.filled = f;
    }

    public String getShape() { return shape; }
    public String getColor() { return color; }
    public int getSize() { return size; }
    public boolean isFilled() { return filled; }

    @Override
    public String toString() {
        return shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
    }
}