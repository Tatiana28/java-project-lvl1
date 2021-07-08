package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

import static hexlet.code.Cli.getNumberFromInput;

public class App {

    private static final int EXIT_GAME_MENU = 0;
    private static final int GREET_GAME_MENU = 1;
    private static final int EVEN_GAME_MENU = 2;
    private static final int CALC_GAME_MENU = 3;
    private static final int GCD_GAME_MENU = 4;
    private static final int PROGRESSION_GAME_MENU = 5;
    private static final int PRIME_GAME_MENU = 6;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_GAME_MENU + " - Greet");
        System.out.println(EVEN_GAME_MENU + " - Even");
        System.out.println(CALC_GAME_MENU + " - Calc");
        System.out.println(GCD_GAME_MENU + " - GCD");
        System.out.println(PROGRESSION_GAME_MENU + " - Progression");
        System.out.println(PRIME_GAME_MENU + " - Prime");
        System.out.println(EXIT_GAME_MENU + " - Exit");
        Scanner sc = new Scanner(System.in);
        int choiceNum = getNumberFromInput(sc);
        System.out.println("Your choice: " + choiceNum);
        if (choiceNum == EXIT_GAME_MENU) {
            return;
        }
        String userName = Cli.userMethod();
        boolean gameResult;
        switch (choiceNum) {
            case EVEN_GAME_MENU:
                gameResult = EvenGame.play();
                break;
            case CALC_GAME_MENU:
                gameResult = CalcGame.play();
                break;
            case GCD_GAME_MENU:
                gameResult = GcdGame.play();
                break;
            case PROGRESSION_GAME_MENU:
                gameResult = ProgressionGame.play();
                break;
            case PRIME_GAME_MENU:
                gameResult = PrimeGame.play();
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
