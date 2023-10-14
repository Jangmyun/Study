package algorithm.greedy;

import java.io.*;

public class Change {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int price = 1000-Integer.parseInt(br.readLine());
    int result =0;

    result += price/500;
    price= price%500;

    result += price/100;
    price = price% 100;

    result += price/50;
    price = price%50;

    result += price/10;
    price = price%10;

    result += price/5;
    price = price%5;

    result += price;

    System.out.println(result);
  }
}
