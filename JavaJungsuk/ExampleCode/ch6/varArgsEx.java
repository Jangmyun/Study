package ExampleCode.ch6;

public class varArgsEx {
    public static void main(String[] args) {
        addAll(1,2,3,4);
        addAll();
    }
    static int addAll(int... args){
        int result = 0;

        if (args.length == 0){
            System.out.println(0);
            return result;
        }

        for(int n : args){
            result += n;
        }
        System.out.println(result);
        return result;
    }
}
