package CodingTest.backjoon.심화;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3_2444 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for( int i=0; i<N; i++){
            for(int j=N-1-i; j>0; j--){
                System.out.print(" ");
            }
            for(int k=2*i+1; k>0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
        for( int i=N-1; i>=1; i--){
            for(int j=N-i; j>0; j--){
                System.out.print(" ");
            }
            for(int k=2*i-1; k>0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}