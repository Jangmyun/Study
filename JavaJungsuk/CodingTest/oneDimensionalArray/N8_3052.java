package CodingTest.oneDimensionalArray;
import java.util.Scanner;
import java.util.ArrayList;

public class N8_3052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> remainderList = new ArrayList<>();
        int[] numArr = new int[10];

        for(int i=0; i<numArr.length; i++) {
            numArr[i] = scanner.nextInt();
            
            if( remainderList.size()==0){
                remainderList.add(numArr[i]%42);
            }
            if(!remainderList.contains(numArr[i]%42)){
                remainderList.add(numArr[i]%42);
            }
        }
        System.out.println(remainderList.size());
    }
}
