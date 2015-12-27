package br.poker.test.cards;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.poker.java.game.GamePoker;
import br.poker.java.helper.CardsGenerator;
import br.poker.java.model.Card;
import br.poker.java.model.Deck;
import br.poker.java.model.Poker;
import br.poker.java.model.PokerHand;
import br.poker.java.model.Suit;
import br.poker.java.model.Value;

public class GamesTest {

	@Test
	public void blackWinWhiteTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.EIGHT);
		Card c4 = new Card(Suit.DIAMONDS, Value.KING);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		cards = new ArrayList<Card>();
		Card c6 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c7 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c8 = new Card(Suit.SPADES, Value.SEVEN);
		Card c9 = new Card(Suit.DIAMONDS, Value.JACK);
		Card c10 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.clear();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.BLACK + " wins - " + Poker.FULL_HOUSE.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void whiteWinBlackTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.EIGHT);
		Card c4 = new Card(Suit.DIAMONDS, Value.JACK);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.CLUBS, Value.ACE);
		Card c7 = new Card(Suit.SPADES, Value.ACE);
		Card c8 = new Card(Suit.CLUBS, Value.EIGHT);
		Card c9 = new Card(Suit.DIAMONDS, Value.KING);
		Card c10 = new Card(Suit.DIAMONDS, Value.FOUR);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.WHITE + " wins - " + Poker.TWO_PAIRS.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tieTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.SPADES, Value.SEVEN);
		Card c2 = new Card(Suit.DIAMONDS, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.EIGHT);
		Card c4 = new Card(Suit.DIAMONDS, Value.JACK);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c7 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c8 = new Card(Suit.HEARTS, Value.EIGHT);
		Card c9 = new Card(Suit.DIAMONDS, Value.JACK);
		Card c10 = new Card(Suit.CLUBS, Value.JACK);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.TIE, game.theWinnerIs());
	}
	
	@Test
	public void tiebreakPairsTest(){
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.EIGHT);
		Card c4 = new Card(Suit.DIAMONDS, Value.KING);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.CLUBS, Value.SIX);
		Card c7 = new Card(Suit.HEARTS, Value.SIX);
		Card c8 = new Card(Suit.HEARTS, Value.EIGHT);
		Card c9 = new Card(Suit.DIAMONDS, Value.JACK);
		Card c10 = new Card(Suit.DIAMONDS, Value.THREE);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.WHITE + " wins - " + Poker.PAIRS.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tiebreakTwoPairsTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.EIGHT);
		Card c4 = new Card(Suit.DIAMONDS, Value.JACK);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c7 = new Card(Suit.DIAMONDS, Value.SEVEN);
		Card c8 = new Card(Suit.HEARTS, Value.EIGHT);
		Card c9 = new Card(Suit.DIAMONDS, Value.KING);
		Card c10 = new Card(Suit.SPADES, Value.KING);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.BLACK + " wins - " + Poker.TWO_PAIRS.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tiebreakThreeOfKindTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.SEVEN);
		Card c4 = new Card(Suit.DIAMONDS, Value.DOUNCE);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.HEARTS, Value.NINE);
		Card c7 = new Card(Suit.DIAMONDS, Value.NINE);
		Card c8 = new Card(Suit.HEARTS, Value.NINE);
		Card c9 = new Card(Suit.DIAMONDS, Value.FOUR);
		Card c10 = new Card(Suit.SPADES, Value.KING);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.BLACK + " wins - " + Poker.THREE_OF_KIND.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tiebreakStraightTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Value.EIGHT);
		Card c3 = new Card(Suit.SPADES, Value.NINE);
		Card c4 = new Card(Suit.DIAMONDS, Value.TEN);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.HEARTS, Value.NINE);
		Card c7 = new Card(Suit.DIAMONDS, Value.TEN);
		Card c8 = new Card(Suit.HEARTS, Value.KING);
		Card c9 = new Card(Suit.CLUBS, Value.QUEEN);
		Card c10 = new Card(Suit.SPADES, Value.JACK);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.BLACK + " wins - " + Poker.STRAIGHT.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tiebreakFlushTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.CLUBS, Value.ACE);
		Card c3 = new Card(Suit.CLUBS, Value.NINE);
		Card c4 = new Card(Suit.CLUBS, Value.TEN);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.DIAMONDS, Value.NINE);
		Card c7 = new Card(Suit.DIAMONDS, Value.TEN);
		Card c8 = new Card(Suit.DIAMONDS, Value.DOUNCE);
		Card c9 = new Card(Suit.DIAMONDS, Value.QUEEN);
		Card c10 = new Card(Suit.DIAMONDS, Value.JACK);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.WHITE + " wins - " + Poker.FLUSH.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tiebreakFullHouseTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.DIAMONDS, Value.SEVEN);
		Card c3 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c4 = new Card(Suit.CLUBS, Value.TEN);
		Card c5 = new Card(Suit.SPADES, Value.TEN);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.DIAMONDS, Value.NINE);
		Card c7 = new Card(Suit.CLUBS, Value.NINE);
		Card c8 = new Card(Suit.HEARTS, Value.NINE);
		Card c9 = new Card(Suit.DIAMONDS, Value.QUEEN);
		Card c10 = new Card(Suit.CLUBS, Value.QUEEN);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.BLACK + " wins - " + Poker.FULL_HOUSE.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tiebreakFourOfKindTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.DIAMONDS, Value.SEVEN);
		Card c3 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c4 = new Card(Suit.SPADES, Value.SEVEN);
		Card c5 = new Card(Suit.SPADES, Value.TEN);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.DIAMONDS, Value.NINE);
		Card c7 = new Card(Suit.CLUBS, Value.NINE);
		Card c8 = new Card(Suit.HEARTS, Value.NINE);
		Card c9 = new Card(Suit.SPADES, Value.NINE);
		Card c10 = new Card(Suit.CLUBS, Value.QUEEN);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.BLACK + " wins - " + Poker.FOUR_OF_KIND.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tiebreakStraightFlushTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.SPADES, Value.SEVEN);
		Card c2 = new Card(Suit.SPADES, Value.EIGHT);
		Card c3 = new Card(Suit.SPADES, Value.JACK);
		Card c4 = new Card(Suit.SPADES, Value.NINE);
		Card c5 = new Card(Suit.SPADES, Value.TEN);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.CLUBS, Value.NINE);
		Card c7 = new Card(Suit.CLUBS, Value.KING);
		Card c8 = new Card(Suit.CLUBS, Value.JACK);
		Card c9 = new Card(Suit.CLUBS, Value.TEN);
		Card c10 = new Card(Suit.CLUBS, Value.QUEEN);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.BLACK + " wins - " + Poker.STRAIGHT_FLUSH.getDesc(), game.theWinnerIs());
	}
	
	@Test
	public void tiebreakHighCardTest() {
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.SPADES, Value.ACE);
		Card c2 = new Card(Suit.HEARTS, Value.THREE);
		Card c3 = new Card(Suit.CLUBS, Value.KING);
		Card c4 = new Card(Suit.DIAMONDS, Value.JACK);
		Card c5 = new Card(Suit.CLUBS, Value.SIX);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand handWhite = new PokerHand(cards);
		handWhite.setHand(GamePoker.WHITE);
		
		Card c6 = new Card(Suit.SPADES, Value.ACE);
		Card c7 = new Card(Suit.HEARTS, Value.FOUR);
		Card c8 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c9 = new Card(Suit.DIAMONDS, Value.TEN);
		Card c10 = new Card(Suit.CLUBS, Value.QUEEN);
		
		cards = new ArrayList<Card>();
		cards.add(c6);
		cards.add(c7);
		cards.add(c8);
		cards.add(c9);
		cards.add(c10);
		
		PokerHand handBlack = new PokerHand(cards);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite,handBlack);
		
		assertEquals(GamePoker.WHITE + " wins - " + Poker.HIGH_CARD.getDesc() + ": " + Value.KING.getValue(), game.theWinnerIs());
	}
}
