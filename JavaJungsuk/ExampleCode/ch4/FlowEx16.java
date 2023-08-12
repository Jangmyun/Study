package ExampleCode.ch4;

public class FlowEx16 {
    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            for (int j=0;j<i; j++ ){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
