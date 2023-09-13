package CodingTest.backjoon.oneDimensionalArray;
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;
public class N10_1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        int N = Integer.parseInt(tmp);
        int[] scoreArr = new int[N];
        
        tmp = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(tmp);
        
        int max = 0;
        int scoreSum =0;
        for(int i=0; i<scoreArr.length; i++){
            scoreArr[i] = Integer.parseInt(st.nextToken());
            if(i==0 || scoreArr[i]> max){
                max = scoreArr[i];
            }
            scoreSum += scoreArr[i];
        }
        double result = scoreSum/(double)max*100/scoreArr.length;

        System.out.println(result);
        
    }
}
