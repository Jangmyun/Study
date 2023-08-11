package Java의정석.ch2;

public class VariableEx2 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int tmp;

        tmp = x;
        x=y;
        y=tmp;

        System.out.println(x);                
        System.out.println(y);

        
    }
}
