package ExampleCode.ch7;

class Product {
    int price;
    int bonusPoint;
    Product(){
        this(0);
    }
    Product (int price){
        this.price= price;
        this.bonusPoint = (int)(price/10f);
    }
}
class Tv1 extends Product {
    Tv1(){                      //조상 클래스의 생성자 호출
        super(100);
    }

    public String toString() {      // Object 클래스의 toString메서드 오버라이딩
        return "Tv";
    }
}
class Computer extends Product {
    Computer(){                 //조상 클래스의 생성자 호출 (price 멤버변수는 조상한테서 상속된거라서)
        super(200);
    }
    public String toString(){
        return "Computer";
    }
}

public class ParameterPolymorphism {
    public static void main(String[] args) {
        System.out.println();
    }
}
