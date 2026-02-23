import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        
        Map<Integer, Double> roomRates = Map.of(
            LegacyRoomTypes.SINGLE, 14000.0,
            LegacyRoomTypes.DOUBLE, 15000.0,
            LegacyRoomTypes.TRIPLE, 12000.0,
            LegacyRoomTypes.DELUXE, 16000.0
        );

        Map<AddOn, Double> addonRates = Map.of(
            AddOn.MESS, 1000.0,
            AddOn.LAUNDRY, 500.0,
            AddOn.GYM, 300.0
        );

        List<Fee> fees = List.of(
            new RoomFee(roomRates),
            new AddonFee(addonRates)
        );

        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), fees);
        calc.process(req);
    }
}