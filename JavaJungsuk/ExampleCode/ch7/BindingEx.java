package ExampleCode.ch7;

class Parent1 {
    int x = 100;        // Parent1 클래스의 멤버변수 x의 값 = 100

    void method(){
        System.out.println("Parent Method");
    }
}
class Child1 extends Parent1 {
    int x = 200;        // Child1 클래스의 멤버변수 x의 값 = 200

    void method(){
        System.out.println("Child Method");
    }
}

public class BindingEx {
    public static void main(String[] args) {
        Parent1 p = new Parent1();
        Child1 c = new Child1();
        System.out.println("p.x = "+ p.x);      // p.x = 100
        p.method();

        System.out.println("c.x = "+ c.x);      // c.x = 200
        c.method();
    }
}
