package ExampleCode.ch6;

import java.time.LocalTime;

class Time {
    int hour;
    int minute;
    int second;


    Time(int h, int m, int s){
        hour = h;
        minute = m;
        second = s;
    }
    Time(){      //생성자  =   인스턴스 변수 초기화 메서드
        LocalTime now = LocalTime.now();
        hour = now.getHour();
        minute = now.getMinute();
        second = now.getSecond();
    }
}

public class ConstructorTest {
    public static void main(String[] args) {
        Time time = new Time();
        System.out.println(time.hour);
        System.out.println(time.minute);
        System.out.println(time.second);

        Time time2 = new Time(23,45,35);
        System.out.println(time2.hour);
    }
}
