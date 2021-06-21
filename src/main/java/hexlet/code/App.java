package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        Scanner sc = new Scanner(System.in);
        int choiceNum = sc.nextInt();
        System.out.println("Your choice: " + choiceNum);
        if (choiceNum == 0) {
            return;
        }
        String userName = Cli.userMethod();
        if (choiceNum != 2) {
            return;
        }
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        int questionNum = getRandomNumber();
        for (int i = 0; i < 3; i++) {

            System.out.println("Question: " + questionNum);
            System.out.print("Your answer: ");
            String answer = "";
            do {
                answer = sc.nextLine();
            } while (answer.isEmpty());

            if (questionNum % 2 == 0 && !"yes".equals(answer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'yes'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            if (questionNum % 2 != 0 && !"no".equals(answer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            System.out.println("Correct!");
            questionNum = getRandomNumber();
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    private static int getRandomNumber() {
        Random randomInt = new Random();
        return randomInt.nextInt();
    }
}

