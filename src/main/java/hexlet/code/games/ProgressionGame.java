package hexlet.code.games;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.NUMBER_OF_TRIES;
import static hexlet.code.Engine.getRandomNumber;
import static hexlet.code.Engine.playGame;

public class ProgressionGame {

    public static final String RULES = "What number is missing in the progression?";
    private static final int DEFAULT_STEP_BOUND = 10;
    private static final int DEFAULT_PROGRESSION_LENGTH = 10;

    public static boolean play() {
        Map<String, String> questionsAnswers = new HashMap<>();

        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            int startNum = getRandomNumber();
            int stepNum = getRandomNumber(DEFAULT_STEP_BOUND);
            int[] progression = getProgression(startNum, stepNum);
            int randomIndexGap = getRandomNumber(progression.length);

            String question = getProgressionWithGap(progression, randomIndexGap);
            String correctAnswer = String.valueOf(progression[randomIndexGap]);

            questionsAnswers.put(question, correctAnswer);
        }
        return playGame(RULES, questionsAnswers);
    }

    private static String getProgressionWithGap(int[] progression, int randomIndexGap) {
        StringBuilder sb = new StringBuilder("Question: ");
        for (int j = 0; j < progression.length; j++) {
            if (j != randomIndexGap) {
                sb.append(progression[j]).append(" ");
            } else {
                sb.append(".. ");
            }
        }
        return sb.toString();
    }

    private static int[] getProgression(int startNum, int stepNum) {
        int[] resultProgression = new int[DEFAULT_PROGRESSION_LENGTH];
        for (int i = 0; i < resultProgression.length; i++, startNum = startNum + stepNum) {
            resultProgression[i] = startNum;
        }
        return resultProgression;
    }
}
