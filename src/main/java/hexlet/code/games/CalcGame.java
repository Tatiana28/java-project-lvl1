package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Cli.getNumberFromInput;
import static hexlet.code.Engine.CYCLE_Q_AND_A;
import static hexlet.code.Engine.getRandomNumber;

public class CalcGame {

    private static final String[] symbols = {"+", "-", "*"};

    public static boolean play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the result of the expression?");
        int leftNum = getRandomNumber();
        int rightNum = getRandomNumber();
        int randomIndex = getRandomNumber(symbols.length);
        for (int i = 0; i < CYCLE_Q_AND_A; i++) {
            System.out.println("Question: " + leftNum + " " + symbols[randomIndex] + " " + rightNum);
            System.out.print("Your answer: ");
            int answer = getNumberFromInput(sc);
            if ("+".equals(symbols[randomIndex]) && leftNum + rightNum != answer) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + (leftNum + rightNum) + "'.");
                return false;
            }
            if ("-".equals(symbols[randomIndex]) && leftNum - rightNum != answer) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + (leftNum - rightNum) + "'.");
                return false;
            }
            if ("*".equals(symbols[randomIndex]) && leftNum * rightNum != answer) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + (leftNum * rightNum) + "'.");
                return false;
            }
            System.out.println("Correct!");
            leftNum = getRandomNumber();
            rightNum = getRandomNumber();
            randomIndex = getRandomNumber(symbols.length);
        }
        return true;
    }
}
