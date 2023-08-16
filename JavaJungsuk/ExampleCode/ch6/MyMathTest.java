package ExampleCode.ch6;

public class MyMathTest {
    public static void main(String[] args) {
        MyMath myMath = new MyMath();
        System.out.println(myMath.max(3,5));
        System.out.println(myMath.PI);
        myMath.printGugudan(2);
    }
}

class MyMath {
    void printGugudan (int dan) {
        for (int i=1; i<=9; i++){
            System.out.printf("%d x %d = %d%n", dan, i, dan*i);
        }
    }
    long add(long a, long b) { return a + b; }
    long subtract(long a, long b) { return a - b; }
    long multiply(long a, long b) { return a * b; }
    double divide(double a, double b) { return a / b; }
    long max(long a, long b) { return (a > b) ? a : b;}

    double PI = 3.141592d;

}
