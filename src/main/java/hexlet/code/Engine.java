package hexlet.code;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final int NUMBER_OF_TRIES = 3;
    private static final Random RANDOM_INT = new Random();
    private static final int DEFAULT_BOUND = 101;

    public static boolean playGame(String rules, Map<String, String> questionsAnswers) {
        Scanner sc = new Scanner(System.in);
        System.out.println(rules);
        for (Map.Entry<String, String> questionAnswer : questionsAnswers.entrySet()) {
            System.out.println(questionAnswer.getKey());

            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            String correctAnswer = questionAnswer.getValue();
            if (!correctAnswer.equals(userAnswer)) {
                printErrorMsg(userAnswer, correctAnswer);
                return false;
            }
            System.out.println("Correct!");
        }
        return true;
    }

    public static void printErrorMsg(Object wrongAnswer, String correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", wrongAnswer, correctAnswer);
    }

    public static int getRandomNumber(int bound) {
        return RANDOM_INT.nextInt(bound);
    }

    public static int getRandomNumber() {
        return getRandomNumber(DEFAULT_BOUND);
    }
}
