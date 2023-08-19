package ExampleCode.ch6;

class Data {
    int x;

}

public class ReferenceReturnEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x =10;                
        Data d2 = copy(d);      //d2 에 d의 값을 복사한 tmp 객체의 주소 전달

        System.out.println(d2.x);
        
    }
    static Data copy(Data d){   // return 값의 타입이 참조형인 copy 메서드
        Data tmp = new Data();  //매서드 내에 Data 객체 생성
        tmp.x = d.x;            //tmp.x 의 값에 d.x 값 복사
        return tmp;             //tmp의 주소값 리턴
    }
    
}
