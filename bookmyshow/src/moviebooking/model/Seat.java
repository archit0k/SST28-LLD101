package model;

public class Seat {
    private String id;
    private int row;
    private int col;

    public Seat(String id, int row, int col) {
        this.id = id;
        this.row = row;
        this.col = col;
    }

    public String getId() { return id; }
}
