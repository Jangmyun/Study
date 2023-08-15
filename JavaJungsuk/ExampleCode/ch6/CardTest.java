package ExampleCode.ch6;

class Card {
    //인스턴스 변수 (개별속성)
    String kind;    // 카드 무늬
    int number;     // 카드 숫자

    //클래스 변수 (공통속성)
    static int width = 100;     //카드 폭
    static int height = 250;    //카드 높이

}

public class CardTest {
    public static void main(String[] args) {
        System.out.println("===========================");
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        Card card1 = new Card();
        Card card2 = new Card();

        card1.kind = "Heart";
        card1.number = 7;

        card2.kind = "Spade";
        card2.number = 4;

        System.out.printf("c1은 %s, %d이며, 크기는 (%d, %d)%n" , card1.kind, card1.number, Card.width, Card.height);
        System.out.printf("c2은 %s, %d이며, 크기는 (%d, %d)%n" , card2.kind, card2.number, Card.width, Card.height);
    
    }
}