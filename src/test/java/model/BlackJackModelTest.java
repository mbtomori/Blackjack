package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class BlackJackModelTest {
    private final ArrayList<String> playerNames = new ArrayList<>();
    private HashMap<String,Enum> endOutcomes = new HashMap<>();
    private BlackJackModel game1;
    private Player player1, player2, player3;
    private Dealer dealer1;
    private Hand hand1, hand2, hand3, hand4;

    @Before
    public void setUp() throws Exception {
        game1 = new BlackJackModel(playerNames);

        hand1 = new Hand();
        hand2 = new Hand();
        hand3 = new Hand();
        hand4 = new Hand();

        dealer1 = new Dealer(hand1);
        player1 = new Player("Elsa Anna", hand2);
        player2 = new Player("Hannah Montana", hand3);
        player3 = new Player("Nancy Drew", hand4);

        // dealer's initial hand
        hand1.add(new Card(Suit.CLUBS, Name.EIGHT));
        hand1.add(new Card(Suit.DIAMONDS, Name.FIVE));

        // player 1's initial hand
        hand2.add(new Card(Suit.SPADES, Name.TEN));
        hand2.add(new Card(Suit.HEARTS, Name.SEVEN));

        // player 2's initial hand
        hand3.add(new Card(Suit.HEARTS, Name.NINE));
        hand3.add(new Card(Suit.SPADES, Name.FOUR));

        // player 3's initial hand
        hand4.add(new Card(Suit.DIAMONDS, Name.EIGHT));
        hand4.add(new Card(Suit.CLUBS, Name.ACE));
    }

    @Test
    public void getPlayers() {
        playerNames.add(player1.getName());
        playerNames.add(player2.getName());
        playerNames.add(player3.getName());

        assertEquals("Elsa Anna", playerNames.get(0));
        assertEquals("Hannah Montana", playerNames.get(1));
        assertEquals("Nancy Drew", playerNames.get(2));
    }


    @Test
    public void findWinners() {
//        assertTrue("WIN", player1.getCurrentHandValue() > dealer1.getCurrentHandValue());
//        assertEquals("WIN", );
    }

    @Test
    public void findTie() {
        hand1.add(new Card(Suit.SPADES, Name.SIX));
        hand2.add(new Card(Suit.DIAMONDS, Name.THREE));
        hand3.add(new Card(Suit.SPADES, Name.FIVE));

        assertEquals("TIE", player3.getCurrentHandValue(), dealer1.getCurrentHandValue());
        assertNotEquals("TIE", player1.getCurrentHandValue(), dealer1.getCurrentHandValue());
    }

    @Test
    public void findLosers() {
        hand1.add(new Card(Suit.SPADES, Name.SIX));
        hand2.add(new Card(Suit.DIAMONDS, Name.THREE));
        hand3.add(new Card(Suit.SPADES, Name.FIVE));

        assertTrue("LOSE", player2.getCurrentHandValue() < dealer1.getCurrentHandValue());
        assertFalse("LOSE",player1.getCurrentHandValue() < dealer1.getCurrentHandValue());
        assertFalse("LOSE",player3.getCurrentHandValue() > dealer1.getCurrentHandValue());

    }

    @Test
    public void findIfPlayerWinsAfterBusts() {
        hand1.add(new Card(Suit.SPADES, Name.SIX));
        hand2.add(new Card(Suit.DIAMONDS, Name.THREE));
        hand3.add(new Card(Suit.SPADES, Name.FIVE));


        assertTrue("WIN", dealer1.getCurrentHandValue() > 21);
        assertTrue("LOSE", player1.getCurrentHandValue() > 21);

    }


    @Test
    public void getOutcomes() {
        endOutcomes.put(player1.getName(), BlackJackModel.Outcome.WIN);
        assertEquals(BlackJackModel.Outcome.WIN,endOutcomes.get(player1.getName()));

    }
}