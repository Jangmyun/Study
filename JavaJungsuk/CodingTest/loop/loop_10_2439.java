package CodingTest.loop;
import java.util.Scanner;
public class loop_10_2439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for(int i =0; i<N; i++){
            
            for(int j=N-i-1; j>0; j-- ){
                    System.out.print(" ");
                }
            for(int k=0; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
