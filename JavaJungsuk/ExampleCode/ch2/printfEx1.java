package Java의정석.ch2;

public class printfEx1 {
    public static void main(String[] args) {
        System.out.println(10.0/3);
        
        System.out.printf("%d", 15);
        System.out.printf("%o", 15);
        System.out.printf("%x%n", 15);
        System.out.printf("%s", Integer.toBinaryString(15));

        float f = 123.456789f;
        System.out.printf("%n%f", f);   //123.456787
        System.out.printf("%n%e", f);   //1.234568e+02

        int ten = 10;
        System.out.printf("[%5d]%n", 1234567);
        System.out.printf("[%-5d]%n", ten);

        String url = "www.google.com";
        System.out.printf("[%20s]", url);

    }
}
