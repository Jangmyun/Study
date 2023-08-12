package ExampleCode.ch2;

public class VariableEx3 {
    public static void main(String[] args) {
        boolean power = true;
        byte b = 127;   // -128 ~ 127

        int oct = 010;  //8진수, 10진수로 8
        int hex = 0x10; //16진수, 10진수로 16

        long l = 10_000_000_000l;

        float f = 3.14f;    //f 생략 불가능
        double d =3.14d;    //d 생략 가능
        double df = 3.14f;  //double이 float보다 넓은 범위라서 오류 안남

        System.out.println(10.);    //10.0 
        System.out.println(.10);    //0.1
        System.out.println(10f);    //10.0
        System.out.println(1e3);    //1000  eN = 10^N


        char ch = 'A';
        int i ='A';
        String str = "ABC";
        String str2 = "DEF";
        String str3 =str + str2;

        System.out.println(str3);
        System.out.println("" + 7 + 7);     // "77"
        System.out.println(7 + 7 + "");     // "14"
    }
}
