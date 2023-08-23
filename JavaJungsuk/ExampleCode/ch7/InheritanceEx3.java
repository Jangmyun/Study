package ExampleCode.ch7;

class Point {
    int x;  // x좌표
    int y;  // y좌표
}

class Circle {
    Point point = new Point();      // 다른 클래스 타입의 참조변수 생성 => 포함관계를 이용하여 단위별로 클래스를 분할 작성 => 코드의 이해를 돕는다.
    int r;      // 반지름
}

public class InheritanceEx3 {
    public static void main(String[] args) {
        
    }    
}
