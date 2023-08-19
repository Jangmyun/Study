package ExampleCode.ch6;

class MyMath3 {
    //메서드 오버로딩
    int add(int a, int b){
        System.out.println(a+b);
        return a+b;
    } 
    long add(int a, long b){
        System.out.println(a+b);
        return a+b;
    }
    long add(long a , int b) {
        System.out.println(a+b);
        return a+b;
    }
    long add (long a, long b){
        System.out.println(a+b);
        return a+b;
    }
    int add(int[] a) {
        int result =0;
        for (int i=0; i <a.length; i++){
            result += a[i];
        }    
        System.out.println(result);
        return result;
    }
}

public class OverloadingTest {
    public static void main(String[] args) {
        MyMath3 mm = new MyMath3();
        int[] a = {1,2,3,4};
        mm.add(a);
        mm.add(3,3);
        mm.add(3,3L);
        mm.add(3L, 3L);
        
    }
}
