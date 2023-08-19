package ExampleCode.ch6;

class MyMath2 {
    long a,b;
    //인스턴스 메서드
    long add() {return a+b;}
    long subtract() { return a-b;}
    long multiply() { return a*b; }
    double divide() { return a / b;}
    //static 메서드
    static long add(long a, long b) {return a+b;}
    static long subtract(long a, long b) { return a-b;}
    static long multiply(long a, long b) { return a*b; }
    static double divide(double a, double b) { return a / b;}
}

public class MyMathTest2 {
    public static void main(String[] args) {
        System.out.println("Static method");
        System.out.println(MyMath2.add(200L, 100L));
        System.out.println(MyMath2.subtract(100l, 50l));
        System.out.println(MyMath2.multiply(5, 5));
        System.out.println(MyMath2.divide(200d, 100d));

        System.out.println();
        
        System.out.println("Instance Method");
        MyMath2 mm = new MyMath2();
        mm.a = 200L;
        mm.b = 100L;
        System.out.println(mm.add());
        System.out.println(mm.subtract());
        System.out.println(mm.multiply());
        System.out.println(mm.divide());
    }
}
