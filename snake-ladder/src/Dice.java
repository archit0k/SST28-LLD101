import java.util.Random;

public class Dice {
    Random rnd = new Random();

    public int roll() {
        return rnd.nextInt(6) + 1;
    }
}
