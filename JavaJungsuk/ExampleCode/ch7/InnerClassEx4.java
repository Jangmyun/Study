package ExampleCode.ch7;

public class InnerClassEx4 {
    private int outerIv = 0;  // private 변수
    private static int outerCv = 0;

    class InstanceInner {
        int iiv = outerIv;  // 외부 클래스의 private인 멤버에도 접근가능
        int iiv2 = outerCv;
    }
    static class StaticInner {
        InnerClassEx4 outer = new InnerClassEx4();
        int siv = outer.outerIv;   // int siv = outerIv 는 static 클래스는 인스턴스 멤버를 객체생성없이 사용 못하므로 outer 객체 생성후에 사용가능
        static int scv = outerCv;  // static 멤버는 객체 생성없이 사용가능
    }

    void method(){
        int lv = 0;
        final int LV = 0;  // 상수 local 변수
        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv;  // JDK 1.8부터 값이 변경되지 않은 변수의 경우 final이 생략돼도 사용가능하다.
            int liv4 = LV;
        }
    }

    public static void main(String[] args) {
        
    }
}
