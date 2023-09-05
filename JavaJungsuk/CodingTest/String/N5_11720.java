package CodingTest.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N5_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] cArr;
        cArr = br.readLine().toCharArray();
        int sum =0;
        for(int i=0; i<N; i++){
            sum += (int)cArr[i]-48;
        }
        System.out.println(sum);
    }
}