package br.poker.test.cards;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.poker.java.helper.ValidatorHand;
import br.poker.java.model.Card;
import br.poker.java.model.Poker;
import br.poker.java.model.PokerHand;
import br.poker.java.model.Suit;
import br.poker.java.model.Value;

public class PokerTest {

	@Test
	public void handPokerPairsTest() {
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.ACE);
		Card c2 = new Card(Suit.SPADES, Value.ACE);
		Card c3 = new Card(Suit.CLUBS, Value.EIGHT);
		Card c4 = new Card(Suit.DIAMONDS, Value.KING);
		Card c5 = new Card(Suit.DIAMONDS, Value.FOUR);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.PAIRS, valHand.getResult());
	}
	
	@Test
	public void handPokerTwoPairsTest(){
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.ACE);
		Card c2 = new Card(Suit.SPADES, Value.ACE);
		Card c3 = new Card(Suit.CLUBS, Value.EIGHT);
		Card c4 = new Card(Suit.DIAMONDS, Value.EIGHT);
		Card c5 = new Card(Suit.DIAMONDS, Value.FOUR);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.TWO_PAIRS, valHand.getResult());
	}
	
	@Test
	public void handPokerThreeOfKindTest(){
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.ACE);
		Card c2 = new Card(Suit.SPADES, Value.ACE);
		Card c3 = new Card(Suit.CLUBS, Value.EIGHT);
		Card c4 = new Card(Suit.DIAMONDS, Value.ACE);
		Card c5 = new Card(Suit.DIAMONDS, Value.FOUR);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.THREE_OF_KIND, valHand.getResult());
	}
	
	@Test
	public void handPokerStraightTest(){
		
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.SPADES, Value.EIGHT);
		Card c3 = new Card(Suit.CLUBS, Value.NINE);
		Card c4 = new Card(Suit.HEARTS, Value.TEN);
		Card c5 = new Card(Suit.DIAMONDS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.STRAIGHT, valHand.getResult());
	}
	
	@Test
	public void handPokerFlushTest(){
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.CLUBS, Value.DOUNCE);
		Card c3 = new Card(Suit.CLUBS, Value.NINE);
		Card c4 = new Card(Suit.CLUBS, Value.ACE);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.FLUSH, valHand.getResult());
	}
	
	@Test
	public void handPokerFullHouseTest(){
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.SEVEN);
		Card c4 = new Card(Suit.DIAMONDS, Value.JACK);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.FULL_HOUSE, valHand.getResult());
	}
	
	@Test
	public void handPokerFourOfKindTest(){
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.SEVEN);
		Card c4 = new Card(Suit.DIAMONDS, Value.SEVEN);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.FOUR_OF_KIND, valHand.getResult());
	}
	
	@Test
	public void handPokerStraightFlushTest(){
		List<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(Suit.CLUBS, Value.SEVEN);
		Card c2 = new Card(Suit.CLUBS, Value.EIGHT);
		Card c3 = new Card(Suit.CLUBS, Value.NINE);
		Card c4 = new Card(Suit.CLUBS, Value.TEN);
		Card c5 = new Card(Suit.CLUBS, Value.JACK);
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.STRAIGHT_FLUSH, valHand.getResult());
	}
	
	@Test
	public void handPokerHighCardTest(){
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
		
		PokerHand hand = new PokerHand(cards);
		ValidatorHand valHand = new ValidatorHand(hand);
		
		assertEquals(Poker.HIGH_CARD, valHand.getResult());
	}
}
