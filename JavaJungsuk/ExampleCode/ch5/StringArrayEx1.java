package ExampleCode.ch5;

import java.util.Arrays;

public class StringArrayEx1 {
    public static void main(String[] args) {
        String[] rsp = {"Rock" , "Scissors", "Paper"};
        System.out.println(Arrays.toString(rsp));

        for(int i=0; i<10; i++){
            int tmp = (int)(Math.random()*3);
            System.out.println(rsp[tmp]);
        }
    }
}

