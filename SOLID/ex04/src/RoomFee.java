import java.util.Map;

public class RoomFee implements Fee {
    private final Map<Integer, Double> rates;

    public RoomFee(Map<Integer, Double> rates) {
        this.rates = rates;
    }

    @Override
    public double calc(BookingRequest req) {
        return rates.getOrDefault(req.roomType, 16000.0);
    }
}