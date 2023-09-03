package CodingTest.oneDimensionalArray;
import java.util.Scanner;

public class N3_10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = new int[9];
        Integer max = null;
        int index=0;
        for( int i=0; i<numArr.length; i++){
            numArr[i] = scanner.nextInt();
            if( max == null) {
                max = numArr[i];
            }
            if( max < numArr[i]){
                max = numArr[i];
                index = i;
            }
        }
        System.out.printf("%d%n%d",max, index+1);
        scanner.close();
    }
}
