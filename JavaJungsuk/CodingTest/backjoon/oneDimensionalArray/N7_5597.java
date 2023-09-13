package CodingTest.backjoon.oneDimensionalArray;
import java.util.Scanner;
import java.util.Arrays;

public class N7_5597 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = new int[28];
        
        for(int i=0; i<numArr.length; i++){
            numArr[i] = scanner.nextInt();
        }
        Arrays.sort(numArr);

        int student1=0, student2=0;
        int numberSum =0;
        int exactSum =0;
        for(int i=1; i<=30; i++){
            numberSum +=i;
        }
        for (int i=0, j=i+1; i<numArr.length; i++, j++){
            if( student1==0 && numArr[i] == j+1){
                student1 = j;
            }
            exactSum += numArr[i];
        }
        student2 = numberSum - exactSum - student1;
        

        System.out.println(student1);
        System.out.println(student2);
        scanner.close();
    }
}
