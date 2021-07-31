package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    public static final String MENU = "Please enter the game number and press Enter.\n"
            + "1 - Greet\n"
            + "2 - Even\n"
            + "3 - Calc\n"
            + "4 - GCD\n"
            + "5 - Progression\n"
            + "6 - Prime\n"
            + "0 - Exit";
    public static final int NUMBER_OF_TRIES = 3;
    private static final int EXIT_GAME_MENU = 0;
    private static final int EVEN_GAME_MENU = 2;
    private static final int CALC_GAME_MENU = 3;
    private static final int GCD_GAME_MENU = 4;
    private static final int PROGRESSION_GAME_MENU = 5;
    private static final int PRIME_GAME_MENU = 6;

    public static void main(String[] args) {
        printMenu();
        Scanner sc = new Scanner(System.in);
        int choiceNum = sc.nextInt();
        System.out.println("Your choice: " + choiceNum);
        startGame(choiceNum);
    }

    public static void printMenu() {
        System.out.println(MENU);
    }

    public static void startGame(int choiceNum) {
        if (choiceNum == EXIT_GAME_MENU) {
            return;
        }
        String userName = Cli.welcomeUser();
        boolean gameResult;
        switch (choiceNum) {
            case EVEN_GAME_MENU:
                gameResult = EvenGame.play(NUMBER_OF_TRIES);
                break;
            case CALC_GAME_MENU:
                gameResult = CalcGame.play(NUMBER_OF_TRIES);
                break;
            case GCD_GAME_MENU:
                gameResult = GcdGame.play(NUMBER_OF_TRIES);
                break;
            case PROGRESSION_GAME_MENU:
                gameResult = ProgressionGame.play(NUMBER_OF_TRIES);
                break;
            case PRIME_GAME_MENU:
                gameResult = PrimeGame.play(NUMBER_OF_TRIES);
                break;
            default:
                return;
        }
        if (gameResult) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
