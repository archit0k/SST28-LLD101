import model.*;
import enums.*;
import service.*;
import strategy.payment.*;
import strategy.pricing.*;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Movie movie = new Movie("1", "Inception", 120);

        Screen screen = new Screen("s1", ScreenType.IMAX);
        for (int i = 1; i <= 6; i++) {
            screen.getSeats().add(new Seat("seat" + i, 1, i));
        }

        Show show = new Show("show1", movie, screen, LocalDateTime.now());

        for (Seat seat : screen.getSeats()) {

            SeatType type;
            double price;

            if (seat.getId().endsWith("1") || seat.getId().endsWith("2")) {
                type = SeatType.SILVER;
                price = 150;
            } else if (seat.getId().endsWith("3") || seat.getId().endsWith("4")) {
                type = SeatType.GOLD;
                price = 200;
            } else {
                type = SeatType.PLATINUM;
                price = 300;
            }

            show.getShowSeats().put(
                seat.getId(),
                new ShowSeat(seat.getId(), type, price)
            );
        }

        BookingService bookingService =
                new BookingService(new DefaultPricing());

        Booking booking = bookingService.bookTickets(
                show,
                Arrays.asList("seat1", "seat2"),
                new UpiPayment()
        );

        System.out.println("Booking successful!");
    }
}
