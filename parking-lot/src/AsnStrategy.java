import java.util.List;
public interface AsnStrategy {
    boolean isCompat(VType vType, SType reqType);
    Slot find(List<Slot> slots, SType reqType, String gateId);
}
