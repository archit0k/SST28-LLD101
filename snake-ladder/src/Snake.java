public class Snake implements Jumper {
    int tail;

    public Snake(int tail) { 
        this.tail = tail; 
    }

    public int getEnd() { 
        return tail; 
    }

    public String getType() { 
        return "Snake"; 
    }
}
