package algorithm.greedy;
import java.io.*;

public class Q2720 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[][] changeArr = new int[T][4];
    for(int i=0; i< changeArr.length; i++){
      int C = Integer.parseInt(br.readLine());
      changeArr[i] = change(C);
    }
    for(int i=0; i<changeArr.length; i++){
      for(int j=0; j<changeArr[i].length; j++){
        System.out.printf("%d " , changeArr[i][j]);
      }
      System.out.println();
    }
  }
  public static int[] change(int money){
    int quater=0;
    int dime=0;
    int nickel =0;
    int penny=0;
    int currentMoney = money;
    if(currentMoney%25 != currentMoney) {
      quater = currentMoney/25;
      currentMoney = currentMoney%25;
    }
    if(currentMoney%10 != currentMoney){
      dime = currentMoney/10;
      currentMoney = currentMoney%10;
    }
    if(currentMoney%5 != currentMoney){
      nickel = currentMoney/5;
      currentMoney = currentMoney%5;
    }
    penny = currentMoney;

    int[] resultArr = {quater, dime, nickel, penny };
    return resultArr;
  }
}
