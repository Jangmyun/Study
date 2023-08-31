package CodingTest.loop;

import java.util.Scanner;

class Plus {
    int a;
    int b;

    Plus(int a, int b){
        this.a = a;
        this.b = b;
    }
    int plusAB() {
        return this.a + this.b;
    }
}

public class loop_2_10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Plus[] caseArr = new Plus[t];
        int[] resultArr = new int[t];

        for (int i =0; i<t; i++){
            int a= scanner.nextInt();
            int b= scanner.nextInt();

            caseArr[i] = new Plus(a,b);
            resultArr[i] = caseArr[i].plusAB();
        }
        for (int i=0; i<resultArr.length; i++){
            System.out.println(resultArr[i]);
        }

        scanner.close();
    }
}
