import java.time.Duration;
import java.time.LocalDateTime;
public class Hourly implements Pricing {
    public double calc(SType slotType, LocalDateTime inT, LocalDateTime outT) {
        long hrs = Duration.between(inT, outT).toHours();
        if (hrs == 0) hrs = 1; 
        switch (slotType) {
            case S: return hrs * 10.0;
            case M: return hrs * 20.0;
            case L: return hrs * 50.0;
            default: return 0.0;
        }
    }
}
