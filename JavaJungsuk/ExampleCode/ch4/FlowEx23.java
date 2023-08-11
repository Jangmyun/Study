package Java의정석.ch4;

public class FlowEx23 {
    public static void main(String[] args) {
        int sum = 0, i=0;

        while (sum <= 100) {
            System.out.printf("%d %d%n", i , sum);
            i++;
            sum += i;
            
        }
    }
}
