package ExampleCode.ch6;

class Data {
    int x;
}

public class ReferenceParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x=10;
        System.out.println("main() : x = "+ d.x);

        change(d);
        System.out.println("After changed(d.x)");
        System.out.println("main() : x = "+ d.x);
    }
    static void change(Data a) {
        a.x = 1000;
        System.out.println("change() : x = " + a.x);
    }
}
