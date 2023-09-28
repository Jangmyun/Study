package ExampleCode.ch7;

abstract class Unit {   // 유닛 추상클래스 작성
    int x,y;
    int hp;
    int damage;
    abstract void move(int x, int y);
    abstract void stop();
    abstract void attack(Unit unit);
}

class Marine extends Unit { // 추상클래스 Unit을 상속받아서 구체화
    Marine( int x, int y){
        this.hp = 150;
        this.damage = 20;
        this.x = x;
        this.y = y;
    }
    void move(int x, int y){
        this.x = x;
        this.y = y;
    }
    void stop(){
        move(this.x, this.y);
    }
    void attack(Unit unit){
        unit.hp -= this.damage;
    }
}

public class AbstractClassEx2 {
    public static void main(String[] args) {
        
    }
}
