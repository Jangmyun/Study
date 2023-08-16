package ExampleCode.ch6;

class Data {
    int x;
}
public class PrimitiveParamEx {
    public static void main(String[] args) {        //call stack에 main() 호출
        Data d = new Data();                //main()에 Data d 생성
        d.x = 10;       // d의 x값 10으로 변경
        System.out.println("main() : x= "+ d.x);    //call stack에 println() 실행/ 종료

        change(d.x);        //call stack에 change() 호출
        System.out.println("After change(d.x)");
        System.out.println("main() : x= "+ d.x);
    }
    static void change(int x) { //기본형 매개변수
        x = 1000;
        System.out.println("change() : x= " + x);   //지역변수 x 
    }
}

