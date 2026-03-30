package service;

import model.*;
import enums.*;
import strategy.payment.PaymentStrategy;
import strategy.pricing.PricingStrategy;
import java.util.*;

public class BookingService {

    private PricingStrategy pricingStrategy;

    public BookingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    private boolean lockSeat(ShowSeat seat) {
        if (seat.getLock().tryLock()) {
            if (seat.getStatus() == SeatStatus.AVAILABLE) {
                seat.setStatus(SeatStatus.LOCKED);
                return true;
            }
            seat.getLock().unlock();
        }
        return false;
    }

    public Booking bookTickets(Show show, List<String> seatIds, PaymentStrategy payment) {

        List<ShowSeat> seats = new ArrayList<>();

        for (String id : seatIds) {
            ShowSeat seat = show.getShowSeats().get(id);
            if (!lockSeat(seat)) {
                throw new RuntimeException("Seat unavailable");
            }
            seats.add(seat);
        }

        double total = 0;
        for (ShowSeat seat : seats) {
            total += pricingStrategy.calculatePrice(seat);
        }

        if (payment.pay(total)) {
            seats.forEach(s -> s.setStatus(SeatStatus.BOOKED));
        } else {
            seats.forEach(s -> {
                s.setStatus(SeatStatus.AVAILABLE);
                s.getLock().unlock();
            });
        }

        return new Booking(UUID.randomUUID().toString(), seats);
    }
}
