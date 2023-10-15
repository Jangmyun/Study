
import java.io.*;
import java.util.ArrayList;

public class SugarDelivery {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    minimumBag(N);
  }

  private static void minimumBag(int N) {
    ArrayList<Integer> resultArrayList = new ArrayList<>();
    ArrayList<Integer> checkResult = new ArrayList<>();
    int result = 0;

    for (int i = 0; N % 5 <= N - (i * 5); i++) {
      result = 0;

      int leftSugar = N - (i * 5);
      result += i;

      if (leftSugar == 0) {
        resultArrayList.add(result);
      } else {
        result += leftSugar / 3;
        leftSugar = leftSugar % 3;

        if (leftSugar != 0) {
          resultArrayList.add(-1);
        } else {
          resultArrayList.add(result);
        }
      }
    } // end of i

    for (int resultValue : resultArrayList) {
      if (!checkResult.contains(resultValue)) {
        checkResult.add(resultValue);
      }
    }

    int min = 10000;
    for (int resultValue : checkResult) {
      if (resultValue != -1 && resultValue < min) {
        min = resultValue;
      }
    }
    if (min == 10000) {
      System.out.println(-1);
      return;
    }
    System.out.println(min);

  }
}
