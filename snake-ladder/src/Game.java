import java.util.*;

public class Game {
    Board brd;
    Queue<Player> q;
    Dice dice;
    Mode mode;

    public Game(int n, int x, String diff) {
        brd = new Board(n);
        dice = new Dice();
        q = new LinkedList<>();

        if (diff.equalsIgnoreCase("hard")) {
            mode = new Hard();
        } else {
            mode = new Easy();
        }

        for (int i = 1; i <= x; i++) {
            q.add(new Player("P" + i));
        }

        buildBoard(n);
    }

    private void buildBoard(int n) {
        Set<Integer> used = new HashSet<>();
        used.add(0);
        used.add(brd.maxPos);
        Random rnd = new Random();


        for (int i = 0; i < n; i++) {
            while (true) {
                int head = rnd.nextInt(brd.maxPos - 2) + 2; 
                int tail = rnd.nextInt(head - 1) + 1;         
                if (!used.contains(head) && !used.contains(tail)) {
                    used.add(head);
                    used.add(tail);
                    brd.addJumper(head, new Snake(tail));
                    break;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            while (true) {
                int start = rnd.nextInt(brd.maxPos - 2) + 1; 
                int end = rnd.nextInt(brd.maxPos - start - 1) + start + 1; 
                if (!used.contains(start) && !used.contains(end)) {
                    used.add(start);
                    used.add(end);
                    brd.addJumper(start, new Ladder(end));
                    break;
                }
            }
        }
    }

    public void makeMove() {
        if (q.size() < 2) return;

        Player p = q.peek();
        int val = dice.roll();
        System.out.println(p.id + " rolled: " + val);

        if (!mode.canMove(p.pos, val)) {
            System.out.println(p.id + " waiting for a 6.");
            swapTurn();
            return;
        }

        boolean extra = mode.getsExtra(p, val);
        int nxt = p.pos + val;

        if (nxt > brd.maxPos) {
            System.out.println(p.id + " overshot. Stays at " + p.pos);
        } else {
            p.pos = nxt;
            if (brd.hasJumper(p.pos)) {
                Jumper jmp = brd.getJumper(p.pos);
                System.out.println("Hit a " + jmp.getType() + "!");
                p.pos = jmp.getEnd();
            }
            System.out.println(p.id + " moved to " + p.pos);
        }

        if (p.pos == brd.maxPos) {
            System.out.println(">>> " + p.id + " WINS! <<<");
            q.poll(); 
            return;
        }

        if (extra) {
            System.out.println(p.id + " goes again!");
        } else {
            swapTurn();
        }
        System.out.println("---");
    }

    private void swapTurn() {
        q.add(q.poll());
    }
}
