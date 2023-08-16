package ExampleCode.ch6;

public class ReferenceParamEx3 {
    public static void main(String[] args) {
        int[] arr = new int[] {3,2,1,6,5,4};

        printArr(arr);
        sortArr(arr);
        printArr(arr);
        System.out.println("sum = " + sumArr(arr));
    }

    static void printArr(int[] x){
        System.out.print("[");
        for(int i=0; i<x.length; i++){
            if(i == x.length-1){
                System.out.print(x[i]);
            }else {
                System.out.print(x[i]+ ",");
            }
            
        }
        System.out.println("]");
    }

    static void sortArr(int[] x) {  //배열 버블정렬
        
        for(int i=0; i<x.length-1; i++){
            for(int j=0; j<x.length-1; j++){
                if(x[j] > x[j+1]){
                    int tmp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = tmp;
                }
            }//end of j
        }//end of i
    }

    static int sumArr(int[] x){     //배열 요소의 합
        int sum =0;

        for(int i=0; i<x.length; i++){
            sum += x[i];
        }

        return sum;
    }
}
