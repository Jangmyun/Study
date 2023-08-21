package ExampleCode.ch6;

class Car {
    String color;
    String gearType;
    int door;

    Car(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
    Car(){
        this("white", "auto", 4);
    }
    Car(Car car){           // 생성자를 사용해서 인스턴스 복사
        color = car.color;
        gearType = car.gearType;
        door = car.door;
    }
}

public class ConstructorTest3 {
    public static void main(String[] args) {
        
    }
}
