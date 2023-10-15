
import java.io.*;
import java.util.StringTokenizer;

public class Coin0 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] coinArr = new int[n];
    int coinNeeded = 0;
    for (int i = coinArr.length - 1; i >= 0; i--) {
      coinArr[i] = Integer.parseInt(br.readLine());
    }
    for (int i = 0; i < coinArr.length; i++) {
      coinNeeded += k / coinArr[i];
      k = k % coinArr[i];
    }
    System.out.println(coinNeeded);
  }
}
