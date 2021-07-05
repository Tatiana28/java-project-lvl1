package hexlet.code.games;

import java.math.BigInteger;
import java.util.Scanner;

import static hexlet.code.Cli.getNumberFromInput;
import static hexlet.code.Engine.CYCLE_Q_AND_A;
import static hexlet.code.Engine.getRandomNumber;

public class GcdGame {

    public static boolean play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Find the greatest common divisor of given numbers.");
        BigInteger leftNum = BigInteger.valueOf(getRandomNumber());
        BigInteger rightNum = BigInteger.valueOf(getRandomNumber());
        for (int i = 0; i < CYCLE_Q_AND_A; i++) {
            System.out.println("Question: " + leftNum + " " + rightNum);
            System.out.print("Your answer: ");
            int answer = getNumberFromInput(sc);
            int gcd = leftNum.gcd(rightNum).intValue();
            if (answer != gcd) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + gcd + "'.");
                return false;
            }
            System.out.println("Correct!");
            leftNum = BigInteger.valueOf(getRandomNumber());
            rightNum = BigInteger.valueOf(getRandomNumber());
        }
        return true;
    }
}
