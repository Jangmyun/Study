package CodingTest.Sort;

public class N3InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};  
        int j;
        int tmp;
        for(int i =0; i< array.length-1; i++){  // 배열요소의 길이-1 만큼 반복 
            j = i;                              // j에 i 인덱스 값 대입하고 i 부터 1씩 감소하며 반복
            while( array[j]> array[j+1]) {      // 우측값이 좌측값보다 작으면 위치 이동
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
