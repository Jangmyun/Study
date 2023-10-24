import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] time = new int[n][2];
    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      time[i][0] = Integer.parseInt(st.nextToken());
      time[i][1] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(time , new Comparator<int[]>() {
      public int compare(int[] o1, int[] o2){
        if(o1[1] == o2[1]){
          
        }
      }
    });

  }

}