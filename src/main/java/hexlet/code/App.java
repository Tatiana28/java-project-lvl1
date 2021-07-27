package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Engine.printMenu();
        Scanner sc = new Scanner(System.in);
        int choiceNum = sc.nextInt();
        System.out.println("Your choice: " + choiceNum);
        Engine.startGame(choiceNum);
    }
}
