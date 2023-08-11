package Java의정석.ch4;

import java.util.Scanner;

public class FlowEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("현재 월을 입력> ");
        String monthInput = scanner.nextLine();
        int month = Integer.parseInt(monthInput);

        switch(month) {
            case 12: case 1: case 2:
                System.out.println(month +"월은 겨울");
                break;
            case 3: case 4: case 5:
                System.out.println(month +"월은 봄");
                break;
            case 6: case 7: case 8:
                System.out.println(month +"월은 여름");
                break;
            case 9: case 10: case 11:
                System.out.println(month +"월은 가을");
                break;
            default:
                System.out.println("1년에 12개월밖에 없음");
        }
        scanner.close();
    }
}
