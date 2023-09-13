package CodingTest.backjoon.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N8_1152 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int i=0;
        while( st.hasMoreTokens()){
            String tmp = st.nextToken();
            i++;
        }  
        System.out.println(i);
    }
}
