package ExampleCode.ch4;

public class FlowEx30 {
    public static void main(String[] args) {

        int sum=0, i=0;
        while(true) {
            if( sum > 100) {
                break;
            }
            sum += ++i;
            System.out.println("i=" +i + "sum=" + sum);

        }
    }
}
