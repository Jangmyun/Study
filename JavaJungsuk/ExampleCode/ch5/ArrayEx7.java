import java.util.Arrays;
public class ArrayEx7 {
    public static void main(String[] args) {
        int[] numArr = new int[10];

        for(int i=0; i<numArr.length; i++){
            numArr[i] = i;              //numArr값 0~9로 초기화
        }

        for( int i =0; i<50; i++){
            int n = (int)(Math.random()*10);
            int tmp =numArr[0];
            numArr[0] = numArr[n];
            numArr[n] = tmp;
        }
        System.out.println(Arrays.toString(numArr));
    }
}
