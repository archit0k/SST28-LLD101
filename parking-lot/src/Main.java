import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Lot lot = new Lot(new Hourly(), new NearestAsn());

        Slot s1 = new Slot("S1", SType.S);
        s1.addDist("G1", 10);
        s1.addDist("G2", 50);
        Slot m1 = new Slot("M1", SType.M);
        m1.addDist("G1", 20);
        m1.addDist("G2", 10);
        Slot l1 = new Slot("L1", SType.L);
        l1.addDist("G1", 30);
        l1.addDist("G2", 5);

        lot.addSlot(s1);
        lot.addSlot(m1);
        lot.addSlot(l1);
        lot.status();

        try {
            Veh v1 = new Veh("KA01", VType.TW);
            Tkt t1 = lot.park(v1, LocalDateTime.now().minusHours(3), SType.S, "G1");

            Veh v2 = new Veh("KA02", VType.TW);
            Tkt t2 = lot.park(v2, LocalDateTime.now().minusHours(2), SType.M, "G2");

            Veh v3 = new Veh("KA03", VType.CAR);
            lot.park(v3, LocalDateTime.now(), SType.S, "G1");

        } catch (BadVehEx | LotFullEx e) {
            System.out.println("Error assigning slot: " + e.getMessage());
        }

        lot.status();

    }
}
