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
    super(100);
}
class Computer extends Product {

}

public class ParameterPolymorphism {
    public static void main(String[] args) {
        System.out.println();
    }
}
