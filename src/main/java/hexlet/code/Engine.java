package hexlet.code;

import java.util.Random;

public class Engine {

    public static final int CYCLE_Q_AND_A = 3;

    private static final Random RANDOM_INT = new Random();

    public static int getRandomNumber() {
        return getRandomNumber(101);
    }

    public static int getRandomNumber(int bound) {
        return RANDOM_INT.nextInt(bound);
    }
}
