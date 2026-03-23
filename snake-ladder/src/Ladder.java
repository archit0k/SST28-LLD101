public class Ladder implements Jumper {
    int top;

    public Ladder(int top) { 
        this.top = top; 
    }

    public int getEnd() { 
        return top; 
    }

    public String getType() { 
        return "Ladder"; 
    }
}
