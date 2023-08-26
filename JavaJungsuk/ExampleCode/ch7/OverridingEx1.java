package ExampleCode.ch7;

class MyPoint {
    int x;
    int y;

    String getLocation() {      // point 인스턴스의 x, y 좌표를 리턴하는 메서드
        return "x : "+ x +  " / y : "+ y; 
    }
}
class MyPoint3D extends MyPoint {
    int z;
    
    String getLocation() {      // Point3D 인스턴스의 x, y, z 좌표를 리턴하는 메서드 / 기존 Point 클래스의 getLocation() 메서드 덮어씀 
        return "x : "+ x +  " / y : "+ y + " / z : "+z;
    }

    public String toString() {  // Object 클래스의 메서드인 toString()도 오버라이딩이 됨
        return "x : "+ x +  " / y : "+ y + " / z : "+z;
    }
}

public class OverridingEx1 {
    public static void main(String[] args) {
        MyPoint3D p = new MyPoint3D();
        p.x = 3;
        p.y = 5;
        p.z = 2;
        System.out.println(p.toString());
        System.out.println(p);                  //p와 p.toString() 결과가 똑같기 때문에 toString() 메서드를 오버라이딩 하면 println()에 인스턴스 이름만 적어도 toString()값이 리턴됨
    }
}
