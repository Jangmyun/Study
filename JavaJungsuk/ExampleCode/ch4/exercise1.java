package Java의정석.ch4;

import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Score: ");
        String input = scanner.nextLine();
        int score = Integer.parseInt(input);

        System.out.println("You're Score: " + score);
        if (score >= 60) {
            System.out.println("Pass!");
        } else {
            System.out.println("Failed!");
        }

        scanner.close();
    }
}
