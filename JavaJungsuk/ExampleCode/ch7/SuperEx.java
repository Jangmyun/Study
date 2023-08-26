package ExampleCode.ch7;

class SuperPoint {
    int x;
    int y;

    SuperPoint(int x, int y){   // 매개변수를 받는 생성자 선언
        this.x = x;
        this.y = y;
    }
    SuperPoint(){
        //생성자 첫줄에 자신 또는 부모 생성자 호출해야함 `this` or `super`
        this(1,1);
    }
}

class SuperPoint3D extends SuperPoint {
    int z;

    SuperPoint3D(int x, int y, int z){
        //생성자 첫줄에 자신 또는 부모 생성자 호출해야함 `this` or `super`
        // 부모 클래스인 SuperPoint 클래스에서 기본 생성자가 정의되어 있으므로 에러가 뜨지 않지만,
        // 기본 생성자 없고 SuperPoint3D 클래스에 부모 생성자 호출하지 않아서 부모 클래스의 기본 생성자 super()가 자식 클래스 생성자 첫줄에 들어가서 오류날거임
        this.x=x;
        this.y=y;
        this.z=z;
    }
}

public class SuperEx {
    public static void main(String[] args) {
        SuperPoint3D ds = new SuperPoint3D(0, 0, 0);
        System.out.println(ds);
    }
}
