package hexlet.code.games;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static hexlet.code.Engine.NUMBER_OF_TRIES;
import static hexlet.code.Engine.getRandomNumber;
import static hexlet.code.Engine.playGame;

public class PrimeGame {

    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int DEFAULT_MAX_BOUND = 1000;

    public static boolean play() {
        Map<String, String> questionsAnswers = new HashMap<>();

        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            int randomNum = getRandomNumber(DEFAULT_MAX_BOUND);

            String question = "Question: " + randomNum;
            String correctAnswer = isPrime(randomNum) ? "yes" : "no";

            questionsAnswers.put(question, correctAnswer);
        }
        return playGame(RULES, questionsAnswers);
    }

    private static boolean isPrime(int number) {
        return IntStream.range(2, number)
                .allMatch(n -> number % n != 0);
    }
}
