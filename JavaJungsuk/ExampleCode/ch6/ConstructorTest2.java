package ExampleCode.ch6;

class Car {
    String color;
    int gearType;  //0 == 오토 1 == 수동
    int seatingCapacity;

    Car(String color, int gearType,int seatingCapacity ){
        this.color = color;
        this.gearType = gearType;
        this.seatingCapacity = seatingCapacity;
    }
    Car(String color){
        this(color, 0, 4);
    }
    Car(){
        this("white", 0, 4);
    }
}

public class ConstructorTest2 {
    public static void main(String[] args) {
        Car car1 = new Car();
        System.out.println(car1.color + " " +car1.gearType+ " " +car1.seatingCapacity);

        Car car2 = new Car("red");
        System.out.println(car2.color);
    }
}
