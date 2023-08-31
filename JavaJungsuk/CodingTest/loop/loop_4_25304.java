package CodingTest.loop;

import java.util.Scanner;

class Num {
    int a;
    int b;

    Num(int a, int b){
        this.a = a;
        this.b = b;
    }
    int multiply() {
        return this.a * this.b;
    }
}

public class loop_4_25304 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();

        Num[] caseArr = new Num[t];
        int result = 0;

        for (int i =0; i<t; i++){
            int a= scanner.nextInt();
            int b= scanner.nextInt();

            caseArr[i] = new Num(a,b);
            result += caseArr[i].multiply();
        }
        if(n == result) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

        scanner.close();
    }
}
