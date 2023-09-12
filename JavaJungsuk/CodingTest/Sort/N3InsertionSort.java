package CodingTest.Sort;

public class N3InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};  
        int j;
        int tmp;
        for(int i =0; i< array.length-1; i++){
            j = i;
            while( array[j]> array[j+1]) {
                tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
                j--;  
            }
        }

        for(int i=0; i<array.length; i++){
            System.out.printf("%d ", array[i]);
        }
    }
}
