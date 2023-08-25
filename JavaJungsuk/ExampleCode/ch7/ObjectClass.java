package ExampleCode.ch7;

class Point {
    int x;
    int y;
}
class Circle extends Point {
    Point point;
    int r;

    Circle(){
        point = new Point();
        r = 1;
    } 
}

public class ObjectClass {
    public static void main(String[] args) {
        Circle c = new Circle();
        Circle c2 = new Circle();
        Circle c3 = c;
        System.out.println(c.toString());
        System.out.println(c);

        System.out.println(c.equals(c2));
        System.out.println(c.equals(c3)); 

    }
}
