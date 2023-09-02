package CodingTest.oneDimensionalArray;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N1_10807 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String tmp = scanner.nextLine();
        int N = Integer.parseInt(tmp);
        int[] Narr = new int[N];

        String numberString = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(numberString);
        
        int i=0;
        while(st.hasMoreTokens()){
            Narr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int v = scanner.nextInt();
        int counter=0;

        for( int n : Narr){
            if(n == v){
                counter++;
            }
        }
        System.out.println(counter);
        
        scanner.close();
    }
}