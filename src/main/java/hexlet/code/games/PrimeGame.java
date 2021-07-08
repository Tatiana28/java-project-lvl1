package hexlet.code.games;

import java.util.Scanner;
import java.util.stream.IntStream;

import static hexlet.code.Engine.CYCLE_Q_AND_A;
import static hexlet.code.Engine.getRandomNumber;

public class PrimeGame {

    private static final int DEFAULT_MAX_BOUND = 1000;

    public static boolean play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        int randomNum = getRandomNumber(DEFAULT_MAX_BOUND);
        for (int i = 0; i < CYCLE_Q_AND_A; i++) {
            System.out.println("Question: " + randomNum);
            System.out.print("Your answer: ");
            String answer;
            do {
                answer = sc.nextLine();
            } while (answer.isEmpty());

            if (isPrime(randomNum) && !"yes".equals(answer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'yes'.");
                return false;
            }
            if (!isPrime(randomNum) && !"no".equals(answer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'.");
                return false;
            }
            System.out.println("Correct!");
            randomNum = getRandomNumber(DEFAULT_MAX_BOUND);
        }
        return true;
    }

    private static boolean isPrime(int number) {
        return IntStream.range(2, number)
                .allMatch(n -> number % n != 0);
    }
}
