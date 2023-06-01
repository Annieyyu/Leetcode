import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    // fields
    private List<Card> cards;

    static Random random = new Random(); // option 5

    public List<Card> getCards() {
        return cards;
    }

    // methods
    public Deck() {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(i, suit));
            }
        }
    }
    public Card deal() {
        return cards.remove(cards.size() - 1);
    }

    public List<Card> deal(int num) {
        List<Card> dealCards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            dealCards.add(deal());
        }
        return dealCards;
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = random.nextInt(cards.size() - i) + i;
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }
}
