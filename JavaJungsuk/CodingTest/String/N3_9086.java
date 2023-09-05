package CodingTest.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[][] cArr = new char[T][2]; 

        for(int i=0; i<cArr.length; i++){
            char[] inputArr = br.readLine().toCharArray();
            cArr[i][0] = inputArr[0];
            cArr[i][1] = inputArr[inputArr.length-1];
        }
        for(int i=0; i<cArr.length; i++){
            System.out.printf("%c%c%n",cArr[i][0],cArr[i][1]);
        }
    }
}
