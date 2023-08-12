package ExampleCode.ch4;

public class FlowEx12 {
    public static void main(String[] args) {
        int result = 0;
        for (int i=1, j=100; i<=50; i++, j--){
            result += i+j;
            System.out.println(i+j);
        }
        System.out.println(result);
    }
}
