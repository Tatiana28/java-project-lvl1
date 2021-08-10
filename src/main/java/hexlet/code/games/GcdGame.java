package hexlet.code.games;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.NUMBER_OF_TRIES;
import static hexlet.code.Engine.getRandomNumber;
import static hexlet.code.Engine.playGame;

public class GcdGame {

    public static final String RULES = "Find the greatest common divisor of given numbers.";

    public static boolean play() {
        Map<String, String> questionsAnswers = new HashMap<>();

        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            int leftNum = getRandomNumber();
            int rightNum = getRandomNumber();

            String question = String.format("Question: %s %s", leftNum, rightNum);
            String correctAnswer = calculateGcd(leftNum, rightNum);

            questionsAnswers.put(question, correctAnswer);
        }
        return playGame(RULES, questionsAnswers);
    }

    private static String calculateGcd(int leftNum, int rightNum) {
        BigInteger leftBigInteger = BigInteger.valueOf(leftNum);
        BigInteger rightBigInteger = BigInteger.valueOf(rightNum);
        return leftBigInteger.gcd(rightBigInteger).toString();
    }
}
