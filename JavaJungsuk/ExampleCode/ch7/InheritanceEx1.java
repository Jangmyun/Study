package ExampleCode.ch7;

class Tv {
    boolean power;
    int channel;

    void power(){ power = !power;}
    void channelUp() { ++channel;}
    void channelDown() { --channel;}
}

class CaptionTv extends Tv {        // Tv 를 상속받는 CaptionTv 클래스 정의
    boolean caption;
    void displayCaption(String text){
        if (caption) {
            System.out.println(text);
        }
    }
}

public class InheritanceEx1 {
    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCaption("Hello World!");
        ctv.caption = true;
        ctv.displayCaption("Hello World!!");
    }
}
