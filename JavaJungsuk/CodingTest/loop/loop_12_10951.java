package CodingTest.loop;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class AB {
    int A;
    int B;
    AB(int A, int B){
        this.A = A;
        this.B = B;
    }
    static int plusAB(int A, int B) {
        return A + B;
    }

}

public class loop_12_10951 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        ArrayList<Integer> resultList = new ArrayList<>();

        while ( scanner.hasNextLine()){
            String ab = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(ab);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            resultList.add(AB.plusAB(a, b));
        }
        for( int i=0; i<resultList.size()-1; i++){
            System.out.println(resultList.get(i));
        }
        scanner.close();
        
    }
}
