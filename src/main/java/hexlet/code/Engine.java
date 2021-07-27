package hexlet.code;

import hexlet.code.games.*;

import java.util.Random;

public class Engine {

    public static final String MENU = "Please enter the game number and press Enter.\n" +
            "1 - Greet\n" +
            "2 - Even\n" +
            "3 - Calc\n" +
            "4 - GCD\n" +
            "5 - Progression\n" +
            "6 - Prime\n" +
            "0 - Exit";

    public static final int CYCLE_Q_AND_A = 3;
    private static final int EXIT_GAME_MENU = 0;
    private static final int GREET_GAME_MENU = 1;
    private static final int EVEN_GAME_MENU = 2;
    private static final int CALC_GAME_MENU = 3;
    private static final int GCD_GAME_MENU = 4;
    private static final int PROGRESSION_GAME_MENU = 5;
    private static final int PRIME_GAME_MENU = 6;
    private static final Random RANDOM_INT = new Random();
    private static final int DEFAULT_BOUND = 101;

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

    public static void printErrorMsg(Object wrongAnswer, Object correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", wrongAnswer, correctAnswer);
    }

    public static int getRandomNumber() {
        return getRandomNumber(DEFAULT_BOUND);
    }

    public static int getRandomNumber(int bound) {
        return RANDOM_INT.nextInt(bound);
    }
}
