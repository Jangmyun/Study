package ExampleCode.ch4;
import java.util.Scanner;

public class FlowEx25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number: ");
        String tmp = scanner.nextLine();
        int number = Integer.parseInt(tmp);
        int sum=0;

        while(!(number == 0)){
            sum += number%10;
            System.out.printf("num=%d sum=%d%n", number , sum);

            number /= 10;
        }
    }
}
