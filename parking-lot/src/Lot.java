import java.time.LocalDateTime;
import java.util.*;

public class Lot {
    List<Slot> slots;
    Pricing prc;
    AsnStrategy asn;
    int tktCnt = 1;

    public Lot(Pricing prc, AsnStrategy asn) {
        this.slots = new ArrayList<>();
        this.prc = prc;
        this.asn = asn;
    }

    public void addSlot(Slot s) { slots.add(s); }

    public Tkt park(Veh v, LocalDateTime inT, SType req, String gate) throws BadVehEx, LotFullEx {
        if (!asn.isCompat(v.type, req)) {
            throw new BadVehEx(v.type + " cannot park in " + req);
        }

        while (true) {
            Slot s = asn.find(slots, req, gate);
            if (s == null) {
                throw new LotFullEx("No " + req + " slots available near " + gate);
            }

            if (s.free.compareAndSet(true, false)) {
                Tkt t = new Tkt("T" + tktCnt++, v, s, inT);
                System.out.println(v.id + " parked at " + s.id);
                return t;
            }

        }
    }

    public double exit(Tkt t, LocalDateTime outT) throws BadTktEx {
        if (t == null || t.s == null) throw new BadTktEx("Invalid ticket");
        
        t.s.free.set(true);
        double bill = prc.calc(t.s.type, t.inT, outT);
        System.out.println(t.v.id + " exited. Bill: $" + bill);
        return bill;
    }

    public void status() {
        int sCnt = 0, mCnt = 0, lCnt = 0;
        for (Slot s : slots) {
            if (s.free.get()) {
                if (s.type == SType.S) sCnt++;
                else if (s.type == SType.M) mCnt++;
                else if (s.type == SType.L) lCnt++;
            }
        }
        System.out.println("Status -> S:" + sCnt + " | M:" + mCnt + " | L:" + lCnt);
    }
}
