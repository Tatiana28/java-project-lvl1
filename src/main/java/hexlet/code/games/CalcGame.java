package hexlet.code.games;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.NUMBER_OF_TRIES;
import static hexlet.code.Engine.getRandomNumber;
import static hexlet.code.Engine.playGame;

public class CalcGame {

    public static final String RULES = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static boolean play() {
        Map<String, String> questionsAnswers = new HashMap<>();

        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            int leftNum = getRandomNumber();
            int rightNum = getRandomNumber();
            String operator = OPERATORS[getRandomNumber(OPERATORS.length)];

            String question = String.format("Question: %d %s %d", leftNum, operator, rightNum);
            String correctAnswer = String.valueOf(calculate(leftNum, rightNum, operator));

            questionsAnswers.put(question, correctAnswer);
        }
        return playGame(RULES, questionsAnswers);
    }

    private static int calculate(int leftNum, int rightNum, String operator) {
        if ("+".equals(operator)) {
            return leftNum + rightNum;
        }
        if ("-".equals(operator)) {
            return leftNum - rightNum;
        }
        return leftNum * rightNum;
    }
}
