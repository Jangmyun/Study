package CodingTest.Sort;

public class N2BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};  
        int tmp;

        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-1-i; j++){
                if( array[j]> array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        for(int i=0; i<array.length; i++){
            System.out.printf("%d ", array[i]);
        }
    }
}
