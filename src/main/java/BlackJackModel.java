import java.util.Scanner;

public class BlackJackModel extends AbstractPlayer {

    public static void main(String[] args) {
        System.out.println("Welcome to your BlackJack Game");

        Scanner input = new Scanner(System.in);

        boolean playerRoundOver = false;
        boolean dealerRoundOver = false;

        // create a new deck of cards shuffles and ready to deal
        Deck blackJackDeck = new Deck();
        blackJackDeck.shuffle();

        // new players - betting player and dealer
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Player bettingPlayer = new Player();
        Player dealer = new Player();


//
//        // player gets two cards from deck
//        playerDeck.add(blackJackDeck.takeTopCard());
//        playerDeck.add(blackJackDeck.takeTopCard());
//
//        // dealer gets two cards from deck
//        dealerDeck.add(blackJackDeck.takeTopCard());
//        dealerDeck.add(blackJackDeck.takeTopCard());

        // Players round
        while(!playerRoundOver) {
            bettingPlayer.;
            System.out.println("Hello Player!\nWould you like to 1. Hit \t 2. Stand");
            int answer = input.nextInt();
            if (answer == 1) {
                bettingPlayer.hit(blackJackDeck);
                if (bettingPlayer.isOver21()) {
                    System.out.println("Player Busts. Dealer wins!");
                }
            }
            else if (answer == 2) {
                bettingPlayer.stand();
            }
            else {
                playerRoundOver = true;
            }
        }

        // Dealers round
        while(!dealerRoundOver) {
            if (dealer.getCurrentHandValue() > bettingPlayer.getCurrentHandValue()) {
                System.out.println("Dealer wins");
            } else if (dealer.getCurrentHandValue() < 17) {
                dealer.hit(blackJackDeck);
            } else if (dealer.isOver21()) {
                System.out.println("Dealer Busts. You win!");
            } else {
                // player value must be higher than dealer value so
                // the player wins
                System.out.println("Player wins");
                dealerRoundOver =true;
            }
        }

    }

    @Override
    public void hit(Deck deck) {

    }
}
