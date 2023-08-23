package ExampleCode.ch7;

class Parent {      // 부모 클래스의 멤버 1개
    int age;
}
class Child extends Parent {    // 자식 클래스의 멤버 2개 (부모로부터 1개 상속, Child의 고유한 메서드 1개)
    void play() {
        System.out.println("Let's play");
    }
}

class Point {   // 2차원 좌표의 한 점 클래스
    int x;
    int y;
}
class Point3D extends Point {   //  3차원 좌표의 한점 클래스 
    int z;                      //  Point 클래스에서 상속받은 x,y 좌표에 z좌표만 추가해서 Point3D 클래스 생성
}

public class InheritanceEx2 {
    public static void main(String[] args) {
        
    }
}
