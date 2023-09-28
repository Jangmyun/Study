package ExampleCode.ch7;

public class InnerClassEx2 {
    class InstanceInner {
        int iv = 100;
        // static int cv = 100;  static Inner class가 아니면 static 변수 선언 불가능
        final static int CONST = 100;  // final static 은 상수라서 가능
    }
    static class StaticInner {
        int iv = 200;
        static int cv = 200;  // static 클래스에서만 static 멤버 정의 가능
    }
    void method() {
        class LocalInner {
            int iv=300;
            // static int cv =300;  static 변수 선언 불가능
            final static int CONST = 300;
        }
    }
    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv); 
        // System.out.println(LocalInner.CONST);   지역 내부 클래스는 외부에서 접근 불가능
    }
}
