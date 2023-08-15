package ExampleCode.ch6;
class Tv {
    //Tv의 멤버변수 (속성)
    String color;
    boolean power;
    int channel;

    //Tv의 메서드 (기능)
    void power(){
        power = !power;
    }
    void channelUp(){
        channel++;
    }
    void channelDown(){
        channel--;
    }
}
public class TvTest {
    public static void main(String[] args) {
        Tv t1 ;      //Tv클래스의 참조변수 t를 선언 
        t1 = new Tv();   //new 연산자로 Tv인스턴스 생성후 그 주소를 참조변수 t에 저장
        //이러면 이제 참조변수 t를 이용해서 Tv 객체에 접근가능함.
        Tv t2;
        t2 = new Tv();
        

        t1.channel = 7;                  //channel 멤버변수에 7 저장
        t1.channelDown();                //channel을 1 줄이는 메서드
        System.out.println(t1.channel);  //t.channel 결과 : 6
        System.out.println(t2.channel);
        t2 = t1;
        System.out.println(t2.channel);
        
    }
}
