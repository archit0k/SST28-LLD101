public interface Mode {
    boolean canMove(int pos, int val);
    boolean getsExtra(Player p, int val);
}

class Easy implements Mode {
    public boolean canMove(int pos, int val) {
        return true; 
    }

    public boolean getsExtra(Player p, int val) {
        return val == 6;
    }
}

class Hard implements Mode {
    public boolean canMove(int pos, int val) {
        return pos > 0 || val == 6; 
    }

    public boolean getsExtra(Player p, int val) {
        if (val != 6) {
            p.sixCnt = 0;
            return false;
        }
        
        p.sixCnt++;
        if (p.sixCnt == 3) {
            p.sixCnt = 0; 
            return false; 
        }
        return true;
    }
}
