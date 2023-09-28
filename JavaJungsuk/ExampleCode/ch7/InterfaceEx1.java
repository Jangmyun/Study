package ExampleCode.ch7;

public class InterfaceEx1 {
    public static void main(String[] args) {
        Fighter f = new Fighter();

        if(f instanceof Unit){
            System.out.println("f는 Unit의 자손");
        }
        if (f instanceof Fightable){
            System.out.println("f는 Fightable 인터페이스 구현함");
        }
        if (f instanceof Movable){
            System.out.println("f는 Movable 인터페이스 구현함");
        }
        if(f instanceof Attackable){
            System.out.println("f는 Attackable 인터페이스 구현함");
        }

        for ( String e : args){
            System.out.println(e);
        }
    }
}

class Unit {
    int HP;
    int x;
    int y;

    Unit(){
        this(100);
    }
    Unit(int HP){
        this.HP = HP;
    }
}

interface Movable {
    void move(int x, int y);
}
interface Attackable {
    void attack(Unit u);
}
interface Fightable extends Movable,Attackable {} // interface 는 여러개 상속 가능

class Fighter extends Unit implements Fightable {
    public void move (int x, int y){ }
    public void attack(Unit u){}
}



