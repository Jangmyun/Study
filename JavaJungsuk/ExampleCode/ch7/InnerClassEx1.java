package ExampleCode.ch7;

class BasicA {
    int a=100;
}
class BasicB {
    void method() {
        BasicA a = new BasicA();
        System.out.println(a.a);  // 다른 클래스의 멤버를 사용하려면 객체생성이 필요함
    }
}

class OuterClass {  // 외부 클래스
    int a = 100;
    class InnerClass {  // 내부 클래스
        void method(){
            System.out.println(a);  // 객체생성 없이 바로 A의 멤버를 사용할 수 있음
        }

    }
}

// 내부 클래스의 scope
class OuterClass2 {  // 외부 클래스
    class InstanceInner {}  // instance 클래스
    static class StaticInner {} // static 클래스
    void method(){      
        class LocalInner {}     // local 클래스
        LocalInner localInner = new LocalInner();
        localInner.toString();
    }
}

public class InnerClassEx1 {
    public static void main(String[] args) {
        
    }
}
