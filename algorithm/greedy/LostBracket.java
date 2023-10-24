import java.io.*;
import java.util.StringTokenizer;

public class LostBracket {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    StringTokenizer numberSt = new StringTokenizer(input, "+-");
    int[] numberArr = new int[numberSt.countTokens()];
    String[] delimiters = new
    for(int i=0; i<numberArr.length; i++){
      numberArr[i] = Integer.parseInt(numberSt.nextToken());
    }
    String delimiterString = String.join();


  }
}
