package CodingTest.loop;
import java.util.Scanner;
public class loop_5_25314 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt()/4;

        for (int i=0; i< n; i++){
            System.out.print("long ");
        }
        System.out.println("int");
        scanner.close();
    }
}
