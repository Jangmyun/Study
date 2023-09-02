package ExampleCode.ch7;

abstract class Player {             // 추상 클래스 
    abstract void play(int pos);    // 추상 메서드
    abstract void stop();
}
class AudioPlayer extends Player {
    void play(int pos){
        System.out.printf("%d 부터 play%n", pos);
    }
    void stop(){
        System.out.println("stop playing");
    }
}

public class AbstractClassEx {
    public static void main(String[] args) {
        // Player p = new Player();     에러남 
        AudioPlayer ap = new AudioPlayer();
        ap.stop();
    }
}
