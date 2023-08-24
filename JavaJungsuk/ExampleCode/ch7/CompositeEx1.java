package ExampleCode.ch7;

class Card {
    String kind;
    String rank;

    static String[] kindArr = { "Spade" , "Heart", "Diamond", "Clover"};
    static String[] rankArr = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    Card(String kind, String rank) {
        this.kind = kind;
        this.rank = rank;
    }
}
class Deck {
    Card[] deck = new Card[52];     //트럼프 카드 총 52장 이므로 길이가 52인 객체배열 생성

    for (String kind: Card.kindArr ) {
        
    } // end of kind
}

public class CompositeEx1 {
    public static void main(String[] args) {
        
    }
}
