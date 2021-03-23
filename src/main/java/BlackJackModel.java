import java.util.ArrayList;
import java.util.Random;

public class BlackJackModel extends Deck{

//    Methods: prepDeck (create and shuffle), deal hands to players,
//    isGameOver? (loops through players to see their score and determine if there is a winner).
//    Tests for BlackJack
    private ArrayList<Card> playingDeck;
    private ArrayList<Players> blackJackPlayer;
    private Players dealer;
    private Players currentPlayer;


    public BlackJackModel(ArrayList<Card> originalDeckList, ArrayList<Card> playingDeck,
                          ArrayList<Players> blackJackPlayer, Players dealer, Players currentPlayer) {
        super(originalDeckList);
        this.playingDeck = playingDeck;
        this.blackJackPlayer = blackJackPlayer;
        this.dealer = dealer;
        this.currentPlayer = currentPlayer;
    }

    public ArrayList<Card> getDeck() {
        return new ArrayList<>(playingDeck);
    }

    public void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        Random randomise = new Random();
        while (!playingDeck.isEmpty()) {
            int random = randomise.nextInt(playingDeck.size());
            shuffledDeck.add(playingDeck.remove(random));
        }
        this.playingDeck = shuffledDeck;
    }

    private boolean isEmpty() {
        return this.playingDeck.size() == 0;
    }

    public Card dealCards(){
        for (player:Players) {
            dealCards();
        }
    }


}
