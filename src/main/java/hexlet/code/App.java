package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

import static hexlet.code.Cli.getNumberFromInput;

public class App {

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        Scanner sc = new Scanner(System.in);
        int choiceNum = getNumberFromInput(sc);
        System.out.println("Your choice: " + choiceNum);
        if (choiceNum == 0) {
            return;
        }
        String userName = Cli.userMethod();
        boolean gameResult = false;
        switch (choiceNum) {
            case 1:
                return;
            case 2:
                gameResult = EvenGame.play();
                break;
            case 3:
                gameResult = CalcGame.play();
        }
        if (gameResult) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
