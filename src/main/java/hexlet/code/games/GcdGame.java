package hexlet.code.games;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.getRandomNumber;
import static hexlet.code.Engine.playGame;

public class GcdGame {

    public static final String RULES = "Find the greatest common divisor of given numbers.";

    public static boolean play(int numberOfTries) {
        Map<String, String> questionsAnswers = new HashMap<>();

        for (int i = 0; i < numberOfTries; i++) {
            BigInteger leftNum = BigInteger.valueOf(getRandomNumber());
            BigInteger rightNum = BigInteger.valueOf(getRandomNumber());

            String question = String.format("Question: %s %s", leftNum, rightNum);
            String correctAnswer = leftNum.gcd(rightNum).toString();

            questionsAnswers.put(question, correctAnswer);
        }
        return playGame(RULES, questionsAnswers);
    }
}
