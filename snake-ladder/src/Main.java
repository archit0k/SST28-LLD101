public class Main {
    public static void main(String[] args) {
        Game g = new Game(10, 3, "hard"); 

        while (g.q.size() >= 2) {
            g.makeMove();
        }
        
        System.out.println("Game Over!");
    }
}
