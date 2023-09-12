package CodingTest.Sort;

public class N1SelectionSort {  // Selection Sort 선택 정렬
    public static void main(String[] args) {
        int min;        //가장 작은 값 저장할 변수 min
        int index=0;    //가장 작은 값이 저장돼있는 index 저장할 변수
        int tmp;        // 값 이동 용 변수
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};  
        for(int i=0; i<array.length; i++){  
            min = 100;          //min 값을 입력받은 배열의 요소의 최댓값보다 크게 줌
            for(int j=i; j<array.length; j++){  // i가 1씩 커질때 커진 i 값부터 배열의 마지막까지 순회
                if(min>array[j]){               // 순회하는 배열요소가 min보다 작으면 min값에 해당 배열요소 값 저장
                    min = array[j];
                    index = j;                  // 배열요소를 저장하면 해당 요소의 인덱스 값을 index 변수에 저장
                }
            } // end of j
            tmp = array[i];                     // 배열요소 중 가장 작은 요소를 가장 앞쪽의 요소와 위치 변경
            array[i] = array[index];
            array[index] = tmp;
        }// end of i

        // 정렬된 배열 출력
        for(int i=0; i<array.length; i++){
            System.out.printf("%d ", array[i]);
        }
    }
}
