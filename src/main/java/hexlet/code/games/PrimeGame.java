package hexlet.code.games;

import hexlet.code.Engine;

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
            String answer = getUserAnswer(sc);

            if (checkUserAnswer(randomNum, answer)) {
                return false;
            }
            System.out.println("Correct!");
            randomNum = getRandomNumber(DEFAULT_MAX_BOUND);
        }
        return true;
    }

    private static boolean checkUserAnswer(int randomNum, String answer) {
        if (isPrime(randomNum) && !"yes".equals(answer)) {
            Engine.printErrorMsg(answer, "yes");
            return true;
        }
        if (!isPrime(randomNum) && !"no".equals(answer)) {
            Engine.printErrorMsg(answer, "no");
            return true;
        }
        return false;
    }

    private static String getUserAnswer(Scanner sc) {
        String answer;
        System.out.print("Your answer: ");
        do {
            answer = sc.nextLine();
        } while (answer.isEmpty());
        return answer;
    }

    private static boolean isPrime(int number) {
        return IntStream.range(2, number)
                .allMatch(n -> number % n != 0);
    }
}
