package CodingTest.backjoon.sort;
import java.util.Scanner;

public class N1_2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] data = new int[N];
        int index=0;
        for(int i=0; i<data.length; i++){
            data[i] = scanner.nextInt();
        }
        for(int i=0; i<data.length; i++){
            int min = 1001;
            int tmp;
            for(int j=i; j<data.length; j++){
                if( min>data[j]){
                    min = data[j];
                    index = j;
                }
                tmp = data[i];
                data[i] = data[index];
                data[index] = tmp;
            }
        }
        for( int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }
}
