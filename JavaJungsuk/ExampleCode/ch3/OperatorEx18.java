package Java의정석.ch3;

//Math.round() 메서드를 사용해서 반올림하는 방법

public class OperatorEx18 {
    public static void main(String[] args) {
        double pi = 3.141592d;
        double shortPi = Math.round(pi*1000) / (double)1000;

        System.out.println(shortPi);
        
    }
}