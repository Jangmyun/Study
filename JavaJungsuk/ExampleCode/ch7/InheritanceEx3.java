package ExampleCode.ch7;

class Point {
    int x;  // x좌표
    int y;  // y좌표
}

class Circle {
    Point point = new Point();      // 다른 클래스 타입의 참조변수 생성 => 포함관계를 이용하여 단위별로 클래스를 분할 작성 => 코드의 이해를 돕는다.
    int r;      // 반지름
}


//다른 예시
class Engine {   //  Car 클래스에 들어갈 Engine 클래스
    int cylinder;       //  Engine 객체의 인스턴스 변수 설정 (몇기통인지, 마력은 몇인지)
    int hoursePower;
    
    Engine(int cylinder, int hoursePower) {
        this.cylinder = cylinder;           //파라미터와 인스턴스 변수명을 구분하기 위해 this. 사용
        this.hoursePower = hoursePower;
        System.out.printf("Your Car Engine has %d cylinder and it's hoursepower is %d%n" , cylinder,hoursePower);       // Engine 인스턴스 생성시 출력될 문장
    }

    Engine() {
        this(4, 140);       // 기본 생성자에 this메서드로 파라미터 집어넣기
    }
}    
class Door {    //  Car 클래스에 들어갈 Door 클래스
    int number;

    Door(int number) {
        System.out.printf("Your Car has %d doors.%n" , number);
    }

    Door() {
        this(4);
    }
}       
class Car {                         
    Engine engine = new Engine();       // Car 클래스 안에 Engine과 Door 클래스 타입의 참조변수를 인스턴스변수로 생성
    Door door = new Door();
}
public class InheritanceEx3 {
    public static void main(String[] args) {
        Car c = new Car();
    }    
}
