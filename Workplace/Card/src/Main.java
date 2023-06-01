import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int id1 = 3;
        int id2 = 2;

        Deck deck = new Deck();
        Player player1 = new BlackJackPlayer(id1);
        Player player2 = new BlackJackPlayer(id2);
        List<BlackJackPlayer> players = new ArrayList<>();
        players.add((BlackJackPlayer) player1);
        players.add((BlackJackPlayer) player2);
        Game game = new Game(deck,players);
        try {
            game.startGame();
        } catch (Exception e){
            throw new RuntimeException("encounter errors");
        }



    }

}