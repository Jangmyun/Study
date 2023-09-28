package ExampleCode.ch7;

public class InnerClassEx3 {
    class InstanceInner {}
    static class StaticInner {}
    InstanceInner iv1 = new InstanceInner();
    StaticInner iv2 = new StaticInner();  // 인스턴스, static 클래스를 Outer 클래스의 인스턴스변수로 사용
    static StaticInner cv = new StaticInner();  // static 클래스를 Outer 클래스의 static 멤버로 사용 

    static void staticMethod(){
        // static 멤버는 인스턴스 멤버에 직접 접근 안됨
        // InstacneInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        // 인스턴스 클래스를 사용하려면 Outer 클래스의 객체를 생성한 후 생성해야함
        InnerClassEx3 outer = new InnerClassEx3();
        InstanceInner obj1 = outer.new InstanceInner();
    }
    public static void main(String[] args) {
           
    }
}
