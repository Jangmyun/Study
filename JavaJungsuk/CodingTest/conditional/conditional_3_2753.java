package CodingTest.conditional;

import java.util.Scanner;

public class conditional_3_2753 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        int leapYear =0;

        if( (year % 4 == 0)) {
            if( !(year%100 ==0)){
                leapYear = 1;
            }
            if ( (year%400 == 0)) {
                leapYear =1;
            }
        }else {
            leapYear =0;
        }
        System.out.println(leapYear);
    }
}
