package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String userMethod() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Hello, " + username + "!");
        return username;
    }
}
