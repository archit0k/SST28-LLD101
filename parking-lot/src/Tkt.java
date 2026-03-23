import java.time.LocalDateTime;
public class Tkt {
    String id;
    Veh v;
    Slot s;
    LocalDateTime inT;
    public Tkt(String id, Veh v, Slot s, LocalDateTime inT) {
        this.id = id; this.v = v; this.s = s; this.inT = inT;
    }
}
