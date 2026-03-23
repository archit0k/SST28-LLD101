import java.util.HashMap;
import java.util.Map;

public class Board {
    int maxPos;
    Map<Integer, Jumper> cells;

    public Board(int n) {
        this.maxPos = n * n;
        this.cells = new HashMap<>();
    }

    public void addJumper(int start, Jumper jmp) {
        cells.put(start, jmp);
    }
    
    public boolean hasJumper(int pos) {
        return cells.containsKey(pos);
    }
    
    public Jumper getJumper(int pos) {
        return cells.get(pos);
    }
}
