package model;

import enums.BookingStatus;
import java.util.*;

public class Booking {
    private String id;
    private List<ShowSeat> seats;
    private BookingStatus status;

    public Booking(String id, List<ShowSeat> seats) {
        this.id = id;
        this.seats = seats;
        this.status = BookingStatus.CREATED;
    }

    public void setStatus(BookingStatus status) { this.status = status; }
}
