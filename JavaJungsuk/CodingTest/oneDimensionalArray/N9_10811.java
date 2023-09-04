package CodingTest.oneDimensionalArray;
import java.util.Scanner;
class Basket1 {
    int ballNumber;

    Basket1 (int ballNumber){
        this.ballNumber = ballNumber;
    }

    static void reverseBasket(Basket1[] bArr, int a, int b){
        int[] arr = new int[b-a+1];
        for(int i=a-1, j=0; i<b; i++,j++){
            arr[j] = bArr[i].ballNumber;
        }
        for( int j=arr.length-1 , i=a-1; j>=0; j-- , i++ ){
            bArr[i].ballNumber = arr[j];
        }
    }
}

public class N9_10811 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Basket1[] bArr = new Basket1[N];
        for( int i=0; i<bArr.length; i++){
            bArr[i] = new Basket1(i+1);
        }
        for(int i=0; i<M; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Basket1.reverseBasket(bArr, a, b);
        }
        for( Basket1 b : bArr){
            System.out.print(b.ballNumber);
            System.out.print(" ");
        }
        scanner.close();
    }
}
