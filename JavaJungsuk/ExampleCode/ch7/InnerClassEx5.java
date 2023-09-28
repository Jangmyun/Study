package ExampleCode.ch7;
class Outer {
    class InstanceInner {
        int iv = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 300;
    }
    
    void method(){
        class LocalInner {
            int iv = 400;
        }
    }
}

public class InnerClassEx5 {
    public static void main(String[] args) {
        Outer outer = new Outer();                                          // outer 클래스의 인스턴스를 먼저 생성해야
        Outer.InstanceInner instanceInner = outer.new InstanceInner();      // inner 인스턴스 클래스의 인스턴스 생성가능

        System.out.println(instanceInner.iv);
        System.out.println(Outer.StaticInner.cv);  // static inner 클래스에서 선언된 static 변수의 경우 외부 클래스 객체 생성 필요없이 사용할 수 있다

        // static inner 클래스의 인스턴스는 외부 클래스 객체 없이 생성가능
        Outer.StaticInner staticInner = new Outer.StaticInner();
        System.out.println(staticInner.iv);


    }
}
