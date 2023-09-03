package CodingTest.oneDimensionalArray;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N3_10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        String tmp = scanner.nextLine();
        int N = Integer.parseInt(tmp);
        int[] nArr = new int[N];
        tmp = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(tmp);

        int i=0;
        Integer min = null;
        Integer max = null;
        while( st.hasMoreTokens()){
            nArr[i] = Integer.parseInt(st.nextToken());
            if( min == null || max == null) {
                min = nArr[i];
                max = nArr[i];
            }

            if(min >nArr[i]){
                min = nArr[i];
            }
            if(max<nArr[i]){
                max = nArr[i];
            }
        }
        System.out.printf("%d %d", min, max);
    }
}
