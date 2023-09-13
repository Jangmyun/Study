package CodingTest.backjoon.conditional;

import java.util.Scanner;

public class conditional_1_1330 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if( a < b ) { System.out.println("<");}
        if( a > b ) { System.out.println(">");}
        if( a == b) { System.out.println("==");}
        scanner.close();
    }
}
