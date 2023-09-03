package CodingTest.oneDimensionalArray;

import java.util.Scanner;
import java.util.StringTokenizer;
class Basket {
    int ballNumber=0;
    static void putBallToBasket(Basket[] bArr, int a, int b, int k){
        for( int i= a-1; i<=b-1; i++ ){
            bArr[i].ballNumber = k;
        } 
    }
    static void exchangeBall(Basket[] bArr, int a, int b){
        int tmp = bArr[a-1].ballNumber;
        bArr[a-1].ballNumber = bArr[b-1].ballNumber;
        bArr[b-1].ballNumber = tmp;
    }
}

public class N5_10810 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(tmp);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Basket[] bArr = new Basket[N];
        for(int i=0; i<bArr.length; i++){
            bArr[i] = new Basket();
            bArr[i].ballNumber = i+1;
        }
        
        for(int index=0; index<M; index++){
            tmp = scanner.nextLine();
            st = new StringTokenizer(tmp);

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            Basket.exchangeBall(bArr, i, j);
        }
        for(int i=0; i<bArr.length; i++){
            System.out.print(bArr[i].ballNumber);
            System.out.print(" ");
        }
        scanner.close();
    }
}
