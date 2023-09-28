package ExampleCode.ch7;

interface I {
    public abstract void play();
}
class B implements I {
    public void play(){
        System.out.println("playing in B");
    }
}
class C implements I {
    public void play(){
        System.out.println("playing in C"); 
    }
}
class A {
    public void playMethod(I i){  //인터페이스를 이용한 다형성 
        //매개변수를 인터페이스로 설정해서 메서드 호출시 해당   "인터페이스를 구현한 클래스의 인스턴스"  를 매개변수로 전달할 수 있다.
        i.play();
    }
}

public class InterfaceEx2 {
    public static void main(String[] args) {
        A a = new A();
        a.playMethod(new B());  // I 를 구현한 B 인스턴스를 매개변수로 받을 수 있음
        a.playMethod(new C());
    }   
}
