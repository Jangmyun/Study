package ExampleCode.ch7;

class Car1 {
    String color;
    int door;

    void drive(){
        System.out.println("drive");
    }
    void stop(){
        System.out.println("stop");
    }

    void doWork(Car1 c){
        if (c instanceof FireEngine){       // c의 인스턴스가 FireEngine의 인스턴스면 코드실행
            FireEngine fe = (FireEngine)c;
            fe.water();
        }
        if (c instanceof Ambulance){        // c의 인스턴스가 Ambulance의 인스턴스면 코드실행
            Ambulance a = (Ambulance)c;
            a.siren();
        }
    }
}
class FireEngine extends Car1 {
    void water() {
        System.out.println("water");
    }
}
class Ambulance extends Car1 {
    void siren() {
        System.out.println("siren");
    }
}

public class ObjectTypeCastingEx {
    public static void main(String[] args) {
        Car1 c = null;
        FireEngine fe1 = new FireEngine();
        FireEngine fe2 = null;

        c = fe1;                // 업캐스팅 / (Car) 생략됨
        fe2 = (FireEngine)c;    // 다운캐스팅 / (FireEngine) 생략 불가능

        fe2.water();

        FireEngine f = new FireEngine();
        f.color = "white";
        f.door = 4;
        Car1 car = (Car1)f;

        System.out.println(car.color);
        car.color = "black";
        System.out.println(f.color);
    }
}
