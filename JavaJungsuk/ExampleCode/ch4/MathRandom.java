package Java의정석.ch4;

public class MathRandom {
    public static void main(String[] args) {
        for (int i = 1; i<= 20; i++) {
            // System.out.println(Math.random());
            // System.out.println(Math.random()*10);
            // System.out.println((int)(Math.random()*10));

            //-5 < x < 5인 난수
            System.out.println((int)(Math.random()*11)-5);

        }
    }
}
