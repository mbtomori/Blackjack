import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * A JUnit4 test class for AbstractPlayer class.
 */
public class AbstractPlayerTest {

    private Player player1;
    private Player player2;
    private Dealer dealer;

    @Before
    public void setUp() {
        player1 = new Player("Maria Konnikova");
        Hand startingHand = new Hand();
        startingHand.add(new Card(Suit.CLUBS, Name.EIGHT));
        startingHand.add(new Card(Suit.CLUBS, Name.ACE));
        player2 = new Player("Justin Bonomo", startingHand);
        dealer = new Dealer("Bellagio Las Vegas");
    }

    @Test
    public void testgetCurrentHandValueStartingHandValue() {
        assertEquals(0, player1.getCurrentHandValue());
        assertEquals(19, player2.getCurrentHandValue());
        assertEquals(0, dealer.getCurrentHandValue());
    }

    @Test
    public void testGetCurrentHandAddedCard() {
        Card aceOfSpades = new Card(Suit.SPADES, Name.ACE);
        player1.getHand().add(aceOfSpades);
        assertEquals(11, player1.getCurrentHandValue());
        player2.getHand().add(aceOfSpades);
        assertEquals(20, player2.getCurrentHandValue());
        dealer.getHand().add(aceOfSpades);
        assertEquals(11, dealer.getCurrentHandValue());
    }

    @Test
    public void testGetHand() {
        Hand startingHand = new Hand();
        startingHand.add(new Card(Suit.CLUBS, Name.EIGHT));
        startingHand.add(new Card(Suit.CLUBS, Name.ACE));
        Player tempPlayer = new Player("Temp", startingHand);
        assertEquals(startingHand, tempPlayer.getHand());
    }

    @Test
    public void testGetName() {
        assertEquals("Maria Konnikova", player1.getName());
        assertEquals("Justin Bonomo", player2.getName());
        assertEquals("Bellagio Las Vegas", dealer.getName());
    }

    @Test
    public void testCalculateHandValue() {
        assertEquals(0, player1.getCurrentHandValue());
        player1.getHand().add(new Card(Suit.HEARTS, Name.ACE));
        assertEquals(11, player1.getCurrentHandValue());
        player1.getHand().add(new Card(Suit.HEARTS, Name.TWO));
        assertEquals(13, player1.getCurrentHandValue());
        player1.getHand().add(new Card(Suit.HEARTS, Name.FIVE));
        assertEquals(18, player1.getCurrentHandValue());
        player1.getHand().add(new Card(Suit.CLUBS, Name.ACE));
        assertEquals(19, player1.getCurrentHandValue());
        player1.getHand().add(new Card(Suit.CLUBS, Name.FIVE));
        assertEquals(14, player1.getCurrentHandValue());
        player1.getHand().add(new Card(Suit.CLUBS, Name.EIGHT));
        assertEquals(22, player1.getCurrentHandValue());
    }

    @Test
    public void testHit() {
        ArrayList<Card> emptyCardList = new ArrayList<>();
        Deck partialDeck = new Deck(emptyCardList);
        // Initialize a deck of four cards
        partialDeck.add(new Card(Suit.DIAMONDS, Name.TEN));
        partialDeck.add(new Card(Suit.CLUBS, Name.THREE));
        partialDeck.add(new Card(Suit.HEARTS, Name.JACK));
        partialDeck.add(new Card(Suit.SPADES, Name.ACE));

        assertEquals(0, player1.getCurrentHandValue());
        player1.hit(partialDeck);
        assertEquals(10, player1.getCurrentHandValue());
        player1.hit(partialDeck);
        assertEquals(13, player1.getCurrentHandValue());
    }

    @Test(expected = IllegalStateException.class)
    public void testHitOver21() {
        ArrayList<Card> emptyCardList = new ArrayList<>();
        Deck partialDeck = new Deck(emptyCardList);
        // Initialize a deck of four cards
        partialDeck.add(new Card(Suit.DIAMONDS, Name.TEN));
        partialDeck.add(new Card(Suit.CLUBS, Name.TEN));
        partialDeck.add(new Card(Suit.HEARTS, Name.THREE));
        partialDeck.add(new Card(Suit.SPADES, Name.ACE));

        player1.hit(partialDeck);
        player1.hit(partialDeck);
        player1.hit(partialDeck);
        player1.hit(partialDeck);
    }
}
