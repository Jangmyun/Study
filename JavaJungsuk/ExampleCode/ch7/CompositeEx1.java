package ExampleCode.ch7;

class Card {
    String kind;
    char major;
    int number;

    static String[] kindArr = { "Spade" , "Heart", "Diamond", "Clover"};
    static char[] majorArr = { 'K', 'Q', 'J'};
    static int[] numberArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    Card(String kind, char major, int number) {
        this.kind = kind;
        this.major = major;
        this.number = number;
    }
}
class Deck {
    Card[] deck = new Card[52];     //트럼프 카드 총 52장 이므로 길이가 52인 객체배열 생성
}

public class CompositeEx1 {
    public static void main(String[] args) {
        
    }
}
