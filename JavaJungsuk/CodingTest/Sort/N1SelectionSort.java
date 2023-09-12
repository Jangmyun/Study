package CodingTest.Sort;

public class N1SelectionSort {  // Selection Sort 선택 정렬
    public static void main(String[] args) {
        int min;        //가장 작은 값 저장할 변수 min
        int index=0;    //가장 작은 값이 저장돼있는 index 저장할 변수
        int tmp;        // 값 이동 용 변수
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        for(int i=0; i<array.length; i++){
            min = 100;
            for(int j=i; j<array.length; j++){
                if(min>array[j]){
                    min = array[j];
                    index = j;
                }
            }
            tmp = array[i];
            array[i] = array[index];
            array[index] = tmp;
        }
        for(int i=0; i<array.length; i++){
            System.out.printf("%d ", array[i]);
        }
    }
}
