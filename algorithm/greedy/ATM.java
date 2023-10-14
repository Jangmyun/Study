package algorithm.greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ATM
 */
public class ATM {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] timeArr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < timeArr.length; i++) {
      timeArr[i] = Integer.parseInt(st.nextToken());
    }

    int j, tmp;
    int result = 0;
    for (int i = 0; i < timeArr.length - 1; i++) {
      j = i;
      while ( (j>=0) && timeArr[j] > timeArr[j + 1]) {
        tmp = timeArr[j];
        timeArr[j] = timeArr[j + 1];
        timeArr[j + 1] = tmp;
        j--;
      }
    }

    for (int i = 0; i < timeArr.length; i++) {
      for(int k=0; k<=i; k++){
        result += timeArr[k];
      }
    }
    System.out.println(result);
  }

}