import java.util.List;
public class NearestAsn implements AsnStrategy {
    public boolean isCompat(VType vType, SType reqType) {
        if (vType == VType.TW) return true; 
        if (vType == VType.CAR && (reqType == SType.M || reqType == SType.L)) return true;
        if (vType == VType.BUS && reqType == SType.L) return true;
        return false;
    }

    public Slot find(List<Slot> slots, SType reqType, String gateId) {
        Slot best = null;
        int minD = Integer.MAX_VALUE;
        for (Slot s : slots) {
            if (s.free.get() && s.type == reqType && s.dists.containsKey(gateId)) {
                int d = s.dists.get(gateId);
                if (d < minD) {
                    minD = d; best = s;
                }
            }
        }
        return best;
    }
}
