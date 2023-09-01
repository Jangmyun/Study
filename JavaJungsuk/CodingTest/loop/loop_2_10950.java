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
    static void printCase(int[] intArr, int[] aArr, int[] bArr){
        for(int i=0; i<intArr.length; i++){
            System.out.printf("Case #%d: %d + %d = %d%n", i+1, aArr[i],bArr[i],intArr[i]);
        }
    }
}

public class loop_2_10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Plus[] caseArr = new Plus[t];
        int[] resultArr = new int[t];
        int[] aArr = new int[t];
        int[] bArr = new int[t];

        for (int i =0; i<t; i++){
            int a= scanner.nextInt();
            int b= scanner.nextInt();

            caseArr[i] = new Plus(a,b);
            
            resultArr[i] = caseArr[i].plusAB();
            aArr[i] = a;
            bArr[i] = b;
        }
        Plus.printCase(resultArr, aArr, bArr);

        scanner.close();
    }
}
