import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Deck deck;
    private List<BlackJackPlayer> players;
    private boolean isEnd;
    public Game(){

    }
    public Game(Deck deck, List<BlackJackPlayer> players){
        this.deck = deck;
        this.players = players;
        this.isEnd = false;
    }

    public void startGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        this.deck.shuffle();
        List<BlackJackPlayer> curPlayers = new ArrayList<>();
        curPlayers.addAll(players);
        while (!isEnd) {
            for (BlackJackPlayer player: players){

                System.out.println("player"+player.getId()+" Do you want to deal card?");
                boolean gotPlayerResponse = false;
                String playerResponse = "";
                while(!gotPlayerResponse) {
                    System.out.println("Enter: yes or no");
                    playerResponse = br.readLine();
                    if (playerResponse.equals("yes") || playerResponse.equals("no")) gotPlayerResponse = true;
                }
                if (playerResponse.equals("yes")){
                    player.addCard(deck.deal());
                    System.out.println("player"+player.getId()+"current score is "+player.score2());
                    if (player.isBursted()){
                        curPlayers.remove(player);
                        continue;
                    }
                    if (player.isBJ()) {
                        System.out.println("player"+player.getId()+" You winBJ!");
                        isEnd = true;
                        break;
                    }
                    if (player.is21()) {
                        System.out.println("player"+player.getId()+" You win21!");
                        isEnd = true;
                        break;
                    }
                }
            }
            players = curPlayers;
        }
    }
}
