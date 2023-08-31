package ExampleCode.ch7;

class Parent {
    private     int prv;    // private
                int dft;    // default
    protected   int prt;    // protected
    public      int pub;    // public

    public void printMembers() {
        System.out.println(prv);
        System.out.println(dft);
        System.out.println(prt);
        System.out.println(pub);
    }
}

public class ModifierEx {
    public static void main(String[] args) {
        Parent p = new Parent();
        // System.out.println(p.prv);       // private은 같은 클래스 내에서만 접근 가능하므로 에러남
        System.out.println(p.dft);
        System.out.println(p.prt);
        System.out.println(p.pub);
    }
}
