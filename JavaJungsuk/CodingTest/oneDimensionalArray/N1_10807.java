package CodingTest.oneDimensionalArray;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class N1_10807 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String nxString = scanner.nextLine();
        StringTokenizer st1 = new StringTokenizer(nxString);
        int N = Integer.parseInt(st1.nextToken());
        int X = Integer.parseInt(st1.nextToken());
        int[] Narr = new int[N];
        ArrayList<Integer> Xarr = new ArrayList<>();

        String numberString = scanner.nextLine();
        StringTokenizer st2 = new StringTokenizer(numberString);
        
        int i=0;
        while(st2.hasMoreTokens()){
            Narr[i] = Integer.parseInt(st2.nextToken());
            if( Narr[i] < X ){
                Xarr.add(Narr[i]);
            }
            i++;
        }

        for( int n : Xarr){
            System.out.printf("%d ",n);
        }
        
        
        scanner.close();
    }
}