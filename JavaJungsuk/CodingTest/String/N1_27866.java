package CodingTest.String;
import java.util.Scanner;
public class N1_27866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        int i = scanner.nextInt();
        char c = S.charAt(i-1);
        System.out.println(c);
        scanner.close();
    }
}
