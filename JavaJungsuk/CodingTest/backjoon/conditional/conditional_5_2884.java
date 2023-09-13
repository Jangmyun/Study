package CodingTest.backjoon.conditional;

import java.util.Scanner;

public class conditional_5_2884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        minute -= 45;
        if (minute < 0 ) {
            minute+= 60;

            if( hour == 0) {
                hour = 23;
            }else {
                hour--;
            }
        }
        System.out.printf("%d %d", hour, minute);

        scanner.close();
    }
}
