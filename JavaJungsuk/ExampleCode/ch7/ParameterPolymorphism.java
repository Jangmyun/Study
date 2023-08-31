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
    Tv1(){                      //조상 클래스의 생성자 호출 (price 멤버변수는 조상한테서 상속된 것 이므로 조상클래스의 생성자 이용)
        super(100);
    }

    public String toString() {      // Object 클래스의 toString메서드 오버라이딩
        return "Tv";
    }
}
class Computer extends Product {
    Computer(){                 //조상 클래스의 생성자 호출 
        super(200);
    }
    public String toString(){
        return "Computer";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint=0;

    void buy(Product p){        //다형성을 이용해서 Product 클래스를 상속받은 다른 클래스도 들어갈 수 있음
        if( this.money< p.price ){
            System.out.println("잔액부족");
            return;
        }
        this.money -= p.price;
        this.bonusPoint += p.bonusPoint;
        System.out.println(p + " 구입완료");
    }
    void checkMoney(){
        System.out.println("현재잔액: "+this.money);
    }
    void checkPoint(){
        System.out.println("현재포인트: "+ this.bonusPoint);
    }
}

public class ParameterPolymorphism {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        buyer.buy(new Computer());
        buyer.checkMoney();
        buyer.checkPoint();
        buyer.buy(new Tv1());
        buyer.checkMoney();
    }
}

