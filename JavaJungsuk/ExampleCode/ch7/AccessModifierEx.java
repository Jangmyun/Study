package ExampleCode.ch7;

class Time {
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour){
        if (!(0<=hour && hour<=24)) return; 
        this.hour = hour;
    }
    public int getHour() { return hour;}
}

public class AccessModifierEx {
    public static void main(String[] args) {
        Time t = new Time();
        t.setHour(22);
        System.out.println(t.getHour());
    }
}
