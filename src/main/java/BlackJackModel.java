import java.util.Scanner;

public class BlackJackModel extends AbstractPlayer {

    public static void main(String[] args) {
        System.out.println("Welcome to your BlackJack Game");

        Scanner input = new Scanner(System.in);

        boolean playerRoundOver = false;
        boolean dealerRoundOver = false;
        boolean gameOver = false;

        // create a new deck of cards shuffles and ready to deal
        Deck blackJackDeck = new Deck();
        blackJackDeck.shuffle();

        // new players - betting player and dealer
        Hand playerHand = new Hand(2);
        Hand dealerHand = new Hand(2);
        Player bettingPlayer = new Player(playerHand);
        Player dealer = new Player(dealerHand);


        // Players round
        try {
            while (!playerRoundOver && !gameOver) {
                bettingPlayer.hit(blackJackDeck);
                bettingPlayer.hit(blackJackDeck);

                System.out.println("Hello Player!");

                // how do i print out the actual card the player has?
                System.out.println("Your card value is " + bettingPlayer.getCurrentHandValue());

                if (bettingPlayer.getCurrentHandValue() == 21){
                    System.out.println("Player wins with a BlackJack");
                    gameOver = true;
                }
                else {
                    System.out.println("Would you like to 1. Hit \t 2. Stand");
                    int answer = input.nextInt();
                    if (answer == 1) {
                        System.out.println("Player chose to hit");
                        bettingPlayer.hit(blackJackDeck);
                        System.out.println(bettingPlayer.getCurrentHandValue());
                        // print out the actual card the player has again
                        if (bettingPlayer.isOver21()) {
                            System.out.println("Player Busts. Dealer wins!");
                            gameOver = true;
                        }
                    } else if (answer == 2) {
                        System.out.println("Player chose to stand");
                        bettingPlayer.stand();
                        playerRoundOver = true;
                    }
                }
            }

            // Dealers round
            while (!dealerRoundOver) {
                dealer.hit(blackJackDeck);
                dealer.hit(blackJackDeck);
                if (dealer.getCurrentHandValue() > bettingPlayer.getCurrentHandValue()) {
                    System.out.println("Dealer wins");
                    gameOver = true;
                } else if (dealer.getCurrentHandValue() < 17) {
                    dealer.hit(blackJackDeck);
                } else if (dealer.isOver21()) {
                    System.out.println("Dealer Busts. Player wins!");
                    gameOver = true;
                } else {
                    // player value must be higher than dealer value so
                    // the player wins
                    System.out.println("Player wins");
                    dealerRoundOver = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // not sure what to do with the information below or how to go about testing this
    @Override
    public void hit(Deck deck) {

    }
}

