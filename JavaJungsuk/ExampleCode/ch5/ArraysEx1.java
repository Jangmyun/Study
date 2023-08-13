package ExampleCode.ch5;

import java.util.Arrays;

public class ArraysEx1 {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4 };
        int[][] arr2D = { {11,12} , {21, 22} };

        System.out.println(Arrays.toString(arr));
        //다차원 배열에서 배열 요소 출력할 때 deepToString 메서드 사용
        System.out.println(Arrays.deepToString(arr2D));  

        String[][] str2D1 = new String[][] {{"abc" , "def"}, {"ABC", "DEF"}};
        String[][] str2D2 = new String[][] {{"abc" , "def"}, {"ABC", "DEF"}};
        //다차원 배열에서 배열 같은지 확인할 때 deepEquals 메서드 사용
        System.out.println(Arrays.deepEquals(str2D1, str2D2));  

        int[] arr1 = {0,1,2,3,4};
        //배열 복사할 때 coptOf 또는 copyOfRange 메서드 사용
        int[] arr2 = Arrays.copyOf(arr1, arr.length);
        int[] arr3 = Arrays.copyOfRange(arr2, 2, 4);
        System.out.println(Arrays.toString(arr3));


    }
}
