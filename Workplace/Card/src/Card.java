public class Card { // ORM
    private final int value;
    private final Suit suit;

    public Card(int val, Suit suit){
        value = val;
        this.suit = suit;
    }
    public int getCardVal() {
        return value;
    }
    public Suit getCardSuit(){
        return suit;
    }
}
