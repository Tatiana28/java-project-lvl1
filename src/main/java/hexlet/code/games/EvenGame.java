package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

import static hexlet.code.Engine.CYCLE_Q_AND_A;
import static hexlet.code.Engine.getRandomNumber;

public class EvenGame {

    public static boolean play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        int questionNum = getRandomNumber();
        for (int i = 0; i < CYCLE_Q_AND_A; i++) {
            System.out.println("Question: " + questionNum);
            String answer = getUserAnswer(sc);

            if (checkUserAnswer(questionNum, answer)) {
                return false;
            }
            System.out.println("Correct!");
            questionNum = getRandomNumber();
        }
        return true;
    }

    private static boolean checkUserAnswer(int questionNum, String answer) {
        if (isEven(questionNum) && !"yes".equals(answer)) {
            Engine.printErrorMsg(answer, "yes");
            return true;
        }
        if (!isEven(questionNum) && !"no".equals(answer)) {
            Engine.printErrorMsg(answer, "no");
            return true;
        }
        return false;
    }

    private static String getUserAnswer(Scanner sc) {
        System.out.print("Your answer: ");
        String answer;
        do {
            answer = sc.nextLine();
        } while (answer.isEmpty());
        return answer;
    }

    private static boolean isEven(int questionNum) {
        return questionNum % 2 == 0;
    }
}
