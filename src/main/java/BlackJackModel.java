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
        Hand playerHand = new Hand(2);
        Hand dealerHand = new Hand(2);
        Player bettingPlayer = new Player(playerHand);
        Player dealer = new Player(dealerHand);

//        playerHand.add(blackJackDeck.takeTopCard());
//        playerHand.add(blackJackDeck.takeTopCard());
//
//        dealerHand.add(blackJackDeck.takeTopCard());
//        dealerHand.add(blackJackDeck.takeTopCard());


        // Players round
        while(!playerRoundOver) {
            bettingPlayer.hit(blackJackDeck);
            bettingPlayer.hit(blackJackDeck);
            // how do i print out what the player has?
            System.out.println(bettingPlayer.getCurrentHandValue());
            System.out.println("Hello Player!\nWould you like to 1. Hit \t 2. Stand");
            int answer = input.nextInt();
            if (answer == 1) {
                System.out.println("Player chose to hit");
                bettingPlayer.hit(blackJackDeck);
                // print out what the player has again
                if (bettingPlayer.isOver21()) {
                    System.out.println("Player Busts. Dealer wins!");
                }
            }
            else if (answer == 2) {
                System.out.println("Player chose to stand");
                bettingPlayer.stand();
            }
            else {
                playerRoundOver = true;
            }
        }

        // Dealers round
        while(!dealerRoundOver) {
            dealer.hit(blackJackDeck);
            dealer.hit(blackJackDeck);
            if (dealer.getCurrentHandValue() > bettingPlayer.getCurrentHandValue()) {
                System.out.println("Dealer wins");
            } else if (dealer.getCurrentHandValue() < 17) {
                dealer.hit(blackJackDeck);
            } else if (dealer.isOver21()) {
                System.out.println("Dealer Busts. Player wins!");
            } else {
                // player value must be higher than dealer value so
                // the player wins
                System.out.println("Player wins");
                dealerRoundOver =true;
            }
        }

    }

    // not sure what to do with the information below or how to go about testing this
    @Override
    public void hit(Deck deck) {

    }
}
