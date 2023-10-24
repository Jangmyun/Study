package ExampleCode.ch7;

class Outer1 {
    int a = 1;

    class Inner {
        int a = 2;
        void method() {
            int a=3;
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(Outer1.this.a);
        }
    } //end of  Inner 
}// end of Outer1

public class InnerClassEx6 {
    public static void main(String[] args) {
        
    }
}
