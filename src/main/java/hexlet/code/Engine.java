package hexlet.code;

import java.util.Random;

public class Engine {

    public static final int CYCLE_Q_AND_A = 3;

    private static final Random RANDOM_INT = new Random();
    private static final int DEFAULT_BOUND = 101;

    public static int getRandomNumber() {
        return getRandomNumber(DEFAULT_BOUND);
    }

    public static int getRandomNumber(int bound) {
        return RANDOM_INT.nextInt(bound);
    }
}
