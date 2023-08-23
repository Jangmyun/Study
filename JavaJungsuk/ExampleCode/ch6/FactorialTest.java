package ExampleCode.ch6;

public class FactorialTest {

    static long factorial(int n) {
        if ( n==0 || n>20) {        // 매개변수 유효성 검사
            return -1;
        }
        if ( n==1 ) {
            return 1;
        }
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
