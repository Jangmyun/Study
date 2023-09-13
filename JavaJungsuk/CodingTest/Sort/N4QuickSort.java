package CodingTest.Sort;

public class N4QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};  
        quickSort(array);
        for(int i=0; i< array.length; i++){
            System.out.printf("%d ", array[i]);
        }
    }
    static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }
    static void quickSort(int[] array, int start, int end){
        int tmp;
        // start가 end와 같거나 큰 시점은 원소가 1개보다 작은 상황이므로 바로 리턴
        if( start >= end){ 
            return;
        }
        int pivot = start;  // 첫번째 값을 pivot으로 지정
        int left = start + 1;   // 부분배열의 왼쪽
        int right = end;        //  부분 배열의 오른쪽

        while(left<=right){
            while( left<= end && array[left]<= array[pivot]){       // pivot보다 큰 값을 만날때까지 반복
                left ++;
            }
            while( right>start && array[right]>= array[pivot]){     // pivot보다 작은 값을 만날때까지 반복
                right--;
            }
            if( left> right){                   // 엇갈렸을 때 pivot값 과 찾은 right 값 교체
                tmp = array[right];
                array[right] = array[pivot];
                array[pivot] = tmp;
            }else {                             // 엇갈리지 않았으면 left와 right 교체
                tmp = array[left];
                array[left]= array[right];
                array[right] = tmp;
            }
        }
        quickSort(array, start, right-1);       // pivot값과 right값 교체후 pivot을 기준으로 배열을 좌우로 분할해서 재귀적으로 정렬 진행
        quickSort(array, right+1, end);
    }
}
