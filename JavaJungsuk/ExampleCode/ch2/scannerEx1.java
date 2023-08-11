package Java의정석.ch2;
import java.util.Scanner;     //Scanner 사용하려면 이 구문 추가해야됨

public class scannerEx1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //Scanner 객체 생성

        //Scanner 객체 사용
        // int num = scanner.nextInt();       //화면에서 입력받은 정수를 num에 저장

        String input = scanner.nextLine();  //입력받은 내용 input에 저장
        int num = Integer.parseInt(input);  //문자열 input을 int타입으로 변경
        System.out.printf("%d", num);

        int num1 = scanner.nextInt();       //int타입으로 바로 입력받기
        int num2 = scanner.nextInt();
        System.out.println(num1);
        System.out.println(num2);

        String input1 = scanner.nextLine();
        float f1 = Float.parseFloat(input1);
        String input2 = scanner.nextLine();
        float f2 = Float.parseFloat(input2);
        System.out.println(f1);
        System.out.println(f2);
        
    }

}
