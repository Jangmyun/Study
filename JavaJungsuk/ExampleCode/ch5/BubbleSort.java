package ExampleCode.ch5;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[10];                        //배열 생성

        for(int i=0; i< arr.length; i++){               //생성된 배열요소에 0~9 정수 넣기
            arr[i] = (int)(Math.random()*10);
            System.out.print(arr[i]);
        }
        System.out.println();

        for(int i=0; i<arr.length-1; i++){
            boolean changed = false;    //자리바꿈 됐는지 체크

            for(int j=0; j<arr.length-1-i; j++){
                if( arr[j]> arr[j+1]) {             //우측값이 더 작으면 자리교체
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= tmp;
                    changed = true;
                }
            }//end for j
            if (!changed) {         //자리교체 없으면 반복문 탈출
                break;          
            }
            for(int k=0; k<arr.length; k++){
                System.out.print(arr[k]);
            }
            System.out.println();
        } //end for i
    }
}
