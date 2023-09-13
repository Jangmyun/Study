package CodingTest.backjoon.loop;
import java.util.ArrayList;
import java.util.Scanner;

class AB {
    int A;
    int B;
    AB(int A, int B){
        this.A = A;
        this.B = B;
    }
    static int plusAB(int A, int B) {
        return A + B;
    }

}
public class loop_11_10952 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> resultList = new ArrayList<>();

        int a=1;
        int b=1;
        while ( !(a==0 && b==0)){
            a = scanner.nextInt();
            b= scanner.nextInt();
            resultList.add(AB.plusAB(a, b));
        }
        for( int i=0; i<resultList.size()-1; i++){
            System.out.println(resultList.get(i));
        }
        scanner.close();
    }
}
