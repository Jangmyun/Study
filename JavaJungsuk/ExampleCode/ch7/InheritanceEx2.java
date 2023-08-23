package ExampleCode.ch7;

class Parent {      // 부모 클래스의 멤버 1개
    int age;
}
class Child extends Parent {    // 자식 클래스의 멤버 2개 (부모로부터 1개 상속, Child의 고유한 메서드 1개)
    void play() {
        System.out.println("Let's play");
    }
}

public class InheritanceEx2 {
    public static void main(String[] args) {
        
    }
}
