package ExampleCode.ch7;

class Card {
    String kind;
    String rank;

    static String[] kindArr = { "Spade" , "Heart", "Diamond", "Clover"};        // 클래스 변수로 배열 생성 (모든 종류의 카드 모양과 rank)
    static String[] rankArr = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    Card(String kind, String rank) {        //카드 생성자 (메서드를 무조건 사용할것이므로 )
        this.kind = kind;
        this.rank = rank;
    }
}
class Deck {
    Card[] deck = new Card[52];     //트럼프 카드 총 52장 이므로 길이가 52인 객체배열 생성

    void newDeck() {        // Deck 인스턴스를 생성후 생성된 deck 객체 배열에 카드의 모양과 숫자를 넣어주는 메서드
        int index=0;    
        for( String kind : Card.kindArr ){          //향상된 for문 사용했고 index를 따로 설정해서 반복문 완료시 index를 1씩 증가
            for( String rank: Card.rankArr ){
                deck[index] = new Card(kind, rank);
                index++;
            }   // end of rank
        } // end of kind
    }

    void shuffleDeck() {   //덱을 shuffle 하는 메서드.
        for( int i=0; i < deck.length; i++){
            int j= (int)(Math.random()*deck.length);
            Card tmp = deck[i];
            deck[i] = deck[j];
            deck[j] = tmp;
        }
    }

    void printDeck() {      // 덱을 출력하는 메서드


        for( int i=0; i<deck.length; i++ ) {
            if( i%4 == 0 ){
                System.out.println();
            }
            System.out.print( deck[i].kind + " "+ deck[i].rank +" / " );
        }        
        System.out.println();
    }
}

public class CompositeEx1 {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.newDeck();
        d.printDeck();
        d.shuffleDeck();
        d.printDeck();
    }
}
