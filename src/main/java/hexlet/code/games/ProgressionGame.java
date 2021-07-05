package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Cli.getNumberFromInput;
import static hexlet.code.Engine.CYCLE_Q_AND_A;
import static hexlet.code.Engine.getRandomNumber;

public class ProgressionGame {

    public static boolean play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What number is missing in the progression?");
        int startNum = getRandomNumber();
        int stepNum = getRandomNumber(10);
        for (int i = 0; i < CYCLE_Q_AND_A; i++) {
            int[] progression = getProgression(startNum, stepNum);
            System.out.print("Question: ");
            int randomIndexGap = getRandomNumber(progression.length);
            for (int j = 0; j < progression.length; j++) {
                if (j != randomIndexGap) {
                    System.out.print(progression[j] + " ");
                } else {
                    System.out.print(".. ");
                }
            }
            System.out.print("\nYour answer: ");
            int answer = getNumberFromInput(sc);
            int correctAnswer = progression[randomIndexGap];
            if (answer != correctAnswer) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                return false;
            }
            System.out.println("Correct!");
            startNum = getRandomNumber();
            stepNum = getRandomNumber(10);
        }
        return true;
    }

    private static int[] getProgression(int startNum, int stepNum) {
        int[] resultProgression = new int[10];
        for (int i = 0; i < resultProgression.length; i++, startNum = startNum + stepNum) {
            resultProgression[i] = startNum;
        }
        return resultProgression;
    }
}
