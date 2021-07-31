package hexlet.code.games;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.getRandomNumber;
import static hexlet.code.Engine.playGame;

public class EvenGame {

    public static final String RULES = "Answer 'yes' if number even otherwise answer 'no'.";

    public static boolean play(int numberOfTries) {
        Map<String, String> questionsAnswers = new HashMap<>();

        for (int i = 0; i < numberOfTries; i++) {
            int questionNum = getRandomNumber();

            String question = "Question: " + questionNum;
            String correctAnswer = questionNum % 2 == 0 ? "yes" : "no";

            questionsAnswers.put(question, correctAnswer);
        }
        return playGame(RULES, questionsAnswers);
    }
}
