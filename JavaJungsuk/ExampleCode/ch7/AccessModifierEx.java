package ExampleCode.ch7;

class Time {
    private int hour;
    private int minute;
    private int second;

    Time(){
        this(0,0,0);
    }

    Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public void setHour(int hour){              //hour가 올바른 값인지 체크하고
        if (isNotValidHour(hour)) return;       //매개변수로 받은 시간을 저장
        this.hour = hour;
    }
    public int getHour() { return hour;}

    public void setMinute(int minute){
        if(isNotValidMinute(minute)) return;
        this.minute = minute;
    }
    public int getMinute() { return minute;}

    public void setSecond(int second){
        if(isNotValidSecond(second)) return;
        this.second = second;
    }
    public int getSecond() { return second;}


    //private 함수
    private boolean isNotValidHour(int hour){   //hour가 올바른 값인지 체크하는 함수
        return !(0<=hour && hour<24);
    }
    private boolean isNotValidMinute(int minute){
        return !(0<=minute && minute<60);
    }
    private boolean isNotValidSecond(int second) {
        return !(0<=second && second<60);
    }
}

public class AccessModifierEx {
    public static void main(String[] args) {
        Time t = new Time(12,35,30);
        
        System.out.println(t.getHour());
    }
}
