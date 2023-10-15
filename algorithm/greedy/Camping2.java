

import java.io.*;
import java.util.StringTokenizer;

public class Camping2 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int i=1;
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());

      if(L == 0){
        break;
      }

      int result =0;
      result += L*(V/P);
      if( L> V%P) result += V%P;
      else result += L;

      System.out.printf("Case %d: %d", i++, result);
      System.out.println();
    }
  }
}
