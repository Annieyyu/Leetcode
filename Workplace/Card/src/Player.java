import java.util.ArrayList;
import java.util.List;

public class Player {
    protected int id;
    protected List<Card> handCards;

    public Player(int id) {
        this.id = id;
        handCards = new ArrayList<>();
    }
//    public Player() {
//
//        handCards = new ArrayList<>();
//    }


    public int getId() {
        return id;
    }

    public void addCard(Card card) {
        // corner case
        handCards.add(card);
    }

    public void addCard(List<Card> cards) { //List better than ArrayList Universal
        // corner case
        for (Card card : cards) {
            addCard(card);
        }
    }

    public Card removeCard(int i) {
        if (handCards.size() == 0 || i > handCards.size()) return null;
        return handCards.remove(i);
    }
}

