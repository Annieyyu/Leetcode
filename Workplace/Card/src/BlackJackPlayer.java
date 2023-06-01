public class BlackJackPlayer extends Player {
    //private int x;

//    public BlackJackHand(int x, int id) {
//        super(id);
//        this.x = x;
//    }

    public BlackJackPlayer(int id) {
        super(id);
    }


    public int score1() {
        if (handCards.size() == 0) return 0;
        int sum = 0;
        for (Card c : handCards) { // 2 4 A 3 7
            int val = c.getCardVal();
            if (val > 1 && val <= 10) {
                sum += val;
            } else if (val == 11 || val == 12 || val == 13) {  // J Q K
                sum += 10;
            } else {  // A what if multiple A  Wrong
                if (sum > 10) sum += 1;
                else sum += 11;
            }
        }
        return sum;
    }

    public int score2() {
        int res = 0, val, aceCount = 0;
        for (Card card : handCards) {
            val = card.getCardVal();
            if (val >= 2 && val <= 10) res += card.getCardVal();
            if (val >= 11 && val <= 13) res += 10;
            if (val == 1) aceCount++;
        }
        for (int i = aceCount; i > 0; i--) {
            if (res + 11 * i + aceCount - i <= 21)
                return res + 11 * i + aceCount - i;
        }
        return res + aceCount;
    }

    public boolean isBursted() {
        return this.score2() > 21;
    }

    public boolean is21() {
        return this.score2() == 21;
    }

    public boolean isBJ() {
        return is21() && handCards.size() == 2;
    }
}
