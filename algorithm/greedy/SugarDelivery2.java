
import java.io.*;

public class SugarDelivery2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int result = 0;

    if (n % 5 == 0) {
      System.out.println(n / 5);
    } else {

      while (n > 0) {
        if (n % 5 == 0) {
          result += n / 5;
          System.out.println(result);
          return;
        }
        if (n < 3) {
          System.out.println(-1);
          return;
        }
        n -= 3;
        result++;
      }
      System.out.println(result);
    }
  }
}
