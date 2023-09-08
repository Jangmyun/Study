package CodingTest.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String twoNumStr = br.readLine();
        StringTokenizer st = new StringTokenizer(twoNumStr);
        int[] twoNumber = new int[2];
        twoNumber[0] = Integer.parseInt(st.nextToken());
        twoNumber[1] = Integer.parseInt(st.nextToken());
        for(int i=0; i<2; i++){
            int one = twoNumber[i]/100;
            int digit = (twoNumber[i]- (one*100) )/10;
            int hundredsDigit = (twoNumber[i] - (one*100) - (digit*10));
            twoNumber[i] = hundredsDigit*100 + digit*10 + one;
        }
        int result = (twoNumber[0]>twoNumber[1]) ? twoNumber[0] : twoNumber[1];

        System.out.println(result);
    }
}
