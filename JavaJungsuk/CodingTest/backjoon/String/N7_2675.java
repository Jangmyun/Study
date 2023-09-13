package CodingTest.backjoon.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class N7_2675 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        ArrayList<char[]> cArrList = new ArrayList<>();
        int R;

        for(int i=0; i<T; i++){
            String tmp = br.readLine();
            st = new StringTokenizer(tmp);
            R = Integer.parseInt(st.nextToken());
            char[] S = st.nextToken().toCharArray();
            char[] resultS = new char[S.length*R];
            int resultIndex=0;
            for(int j=0; j<S.length; j++){
                for(int k=0; k<R; k++){
                    resultS[resultIndex] = S[j];
                    resultIndex++;
                }
            }
            cArrList.add(resultS);
        }
        for(int i=0; i<cArrList.size(); i++){
            char[] result = cArrList.get(i);
            for(int j=0; j<result.length; j++){
                System.out.printf("%c", result[j]);
            }
            System.out.println();
        }
        
    }
}
