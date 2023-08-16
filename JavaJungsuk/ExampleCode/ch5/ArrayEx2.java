package ExampleCode.ch5;

import java.util.Arrays;

public class ArrayEx2 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        for (int i=0; i<arr1.length; i++){
            arr1[i] = i;
        }
        char[] charArr = { 'A', 'B', 'C', 'D'};

        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(charArr);
    }
}
