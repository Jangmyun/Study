package algorithm.greedy;

import java.io.*;

public class MicroWave {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[] buttonUsesArr = getButtonUses(T);

    for (int i = 0; i < buttonUsesArr.length; i++) {
      System.out.printf("%d ", buttonUsesArr[i]);
    }
  }

  public static int[] getButtonUses(int T) {
    int[] resultArr;
    final int A = 300;
    final int B = 60;
    final int C = 10;
    int currentTime = T;
    int aUse = 0;
    int bUse = 0;
    int cUse = 0;

    if (T % A != T) {
      aUse = currentTime / A;
      currentTime = currentTime % A;
    }
    if (T % B != T) {
      bUse = currentTime / B;
      currentTime = currentTime % B;
    }
    if (T % C != T) {
      cUse = currentTime / C;
      currentTime = currentTime % C;
    }

    if (currentTime != 0) {
      resultArr = new int[] { -1 };
      return resultArr;
    }
    return new int[] { aUse, bUse, cUse };
  }
}
