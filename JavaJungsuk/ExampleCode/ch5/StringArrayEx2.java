package ExampleCode.ch5;

//커맨드라인으로 입력 받기

public class StringArrayEx2 {
    public static void main(String[] args) {
        System.out.printf("매개변수 개수: %d%n" , args.length);
        for(int i=0; i<args.length; i++){
            System.out.printf("args[%d] = \"%s\"" , i, args[i]);
        }

    }
}
