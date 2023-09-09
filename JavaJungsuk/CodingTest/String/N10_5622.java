package CodingTest.String;

import java.util.Scanner;

public class N10_5622 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chrList = scanner.nextLine().toCharArray();
        int result =0;
        for(int i=0; i<chrList.length; i++){
            result += alpToNum(chrList[i]);
        }
        System.out.println(result);


    }
    static int alpToNum(char alp){
        String[] alpList = {"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String tmp = alp + "";
        for( int i =0; i<alpList.length; i++){
            if( alpList[i].contains(tmp)){
                return i+2;
            }
        }
        return -1;
    }
}
