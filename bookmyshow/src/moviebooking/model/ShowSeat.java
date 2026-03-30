package model;

import enums.*;
import java.util.concurrent.locks.ReentrantLock;

public class ShowSeat {
    private String seatId;
    private SeatType type;
    private double basePrice;
    private SeatStatus status;
    private ReentrantLock lock = new ReentrantLock();

    public ShowSeat(String seatId, SeatType type, double basePrice) {
        this.seatId = seatId;
        this.type = type;
        this.basePrice = basePrice;
        this.status = SeatStatus.AVAILABLE;
    }

    public String getSeatId() { return seatId; }
    public SeatType getType() { return type; }
    public double getBasePrice() { return basePrice; }
    public SeatStatus getStatus() { return status; }
    public void setStatus(SeatStatus status) { this.status = status; }
    public ReentrantLock getLock() { return lock; }
}
