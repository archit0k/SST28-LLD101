import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Slot {
    String id;
    SType type; 
    AtomicBoolean free;
    Map<String, Integer> dists; 

    public Slot(String id, SType type) {
        this.id = id;
        this.type = type;
        this.free = new AtomicBoolean(true);
        this.dists = new HashMap<>();
    }

    public void addDist(String gate, int d) {
        dists.put(gate, d);
    }
}
