package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

import static hexlet.code.Engine.CYCLE_Q_AND_A;
import static hexlet.code.Engine.getRandomNumber;

public class ProgressionGame {

    private static final int DEFAULT_STEP_BOUND = 10;
    private static final int DEFAULT_PROGRESSION_LENGTH = 10;

    public static boolean play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What number is missing in the progression?");
        int startNum = getRandomNumber();
        int stepNum = getRandomNumber(DEFAULT_STEP_BOUND);
        for (int i = 0; i < CYCLE_Q_AND_A; i++) {
            int[] progression = getProgression(startNum, stepNum);
            int randomIndexGap = generateQuestion(progression);
            System.out.print("\nYour answer: ");
            int userAnswer = sc.nextInt();
            int correctAnswer = progression[randomIndexGap];
            if (userAnswer != correctAnswer) {
                Engine.printErrorMsg(userAnswer, correctAnswer);
                return false;
            }
            System.out.println("Correct!");
            startNum = getRandomNumber();
            stepNum = getRandomNumber(DEFAULT_STEP_BOUND);
        }
        return true;
    }

    private static int generateQuestion(int[] progression) {
        System.out.print("Question: ");
        int randomIndexGap = getRandomNumber(progression.length);
        for (int j = 0; j < progression.length; j++) {
            if (j != randomIndexGap) {
                System.out.print(progression[j] + " ");
            } else {
                System.out.print(".. ");
            }
        }
        return randomIndexGap;
    }

    private static int[] getProgression(int startNum, int stepNum) {
        int[] resultProgression = new int[DEFAULT_PROGRESSION_LENGTH];
        for (int i = 0; i < resultProgression.length; i++, startNum = startNum + stepNum) {
            resultProgression[i] = startNum;
        }
        return resultProgression;
    }
}
