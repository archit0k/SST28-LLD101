import java.time.LocalDateTime;
public interface Pricing {
    double calc(SType slotType, LocalDateTime inT, LocalDateTime outT);
}
