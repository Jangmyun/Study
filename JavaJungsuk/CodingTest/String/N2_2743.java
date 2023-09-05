package CodingTest.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2_2743  {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        System.out.println(cArr.length);
    }
}
