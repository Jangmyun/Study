package ExampleCode.ch6;

public class ReferenceParamEx2 {
    public static void main(String[] args) {
        int[] x = {10};     //길이가 1인 정수 배열  x[0] = 10  
        System.out.println("main() : x = "+ x[0]);
        
        change(x);
        System.out.println("After change(x)");
        System.out.println("main() : x = "+ x[0]);
        
    }
    static void change(int[] a){   //정수배열 (참조형) 받음
        a[0] = 1000;
        System.out.println("change() : x = "+ a[0]);
    }
}
