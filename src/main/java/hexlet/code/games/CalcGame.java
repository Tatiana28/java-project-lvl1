package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.CYCLE_Q_AND_A;
import static hexlet.code.Engine.getRandomNumber;

public class CalcGame {

    private static final String[] SYMBOLS = {"+", "-", "*"};

    public static boolean play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the result of the expression?");
        int leftNum = getRandomNumber();
        int rightNum = getRandomNumber();
        int randomIndex = getRandomNumber(SYMBOLS.length);
        for (int i = 0; i < CYCLE_Q_AND_A; i++) {
            System.out.println("Question: " + leftNum + " " + SYMBOLS[randomIndex] + " " + rightNum);
            System.out.print("Your answer: ");
            int answer = sc.nextInt();
            if ("+".equals(SYMBOLS[randomIndex]) && leftNum + rightNum != answer) {
                String msg = "'" + answer + "' is wrong answer ;(. Correct answer was '" + (leftNum + rightNum) + "'.";
                System.out.println(msg);
                return false;
            }
            if ("-".equals(SYMBOLS[randomIndex]) && leftNum - rightNum != answer) {
                String msg = "'" + answer + "' is wrong answer ;(. Correct answer was '" + (leftNum - rightNum) + "'.";
                System.out.println(msg);
                return false;
            }
            if ("*".equals(SYMBOLS[randomIndex]) && leftNum * rightNum != answer) {
                String msg = "'" + answer + "' is wrong answer ;(. Correct answer was '" + (leftNum * rightNum) + "'.";
                System.out.println(msg);
                return false;
            }
            System.out.println("Correct!");
            leftNum = getRandomNumber();
            rightNum = getRandomNumber();
            randomIndex = getRandomNumber(SYMBOLS.length);
        }
        return true;
    }
}
