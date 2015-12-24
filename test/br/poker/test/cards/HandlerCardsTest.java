package br.poker.test.cards;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.poker.java.helper.CardsGenerator;
import br.poker.java.model.Card;
import br.poker.java.model.Deck;
import br.poker.java.model.Suit;
import br.poker.java.model.Value;

public class HandlerCardsTest {

	@Test
	public void numberOfCardsTest() {
		
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		
		assertEquals(52, deck.getCards().size());
	}

	@Test
	public void numberOfSuitsInTheDeckTest(){
		
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		
		List<Suit> suits = new ArrayList<Suit>();
		
		for(Card card : deck.getCards()){
			if(!suits.contains(card.getSuit())){
				suits.add(card.getSuit());
			}
		}
		
		assertEquals(4,suits.size());
	}
	
	@Test
	public void numberOfCardsBySuitTest(){
		
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		
		int clubs = 0;
		int hearts = 0;
		int spades = 0;
		int diamonds = 0;
		
		for(Card card : deck.getCards()){
			if(card.getSuit().equals(Suit.CLUBS)){
				clubs++;
			}
			if(card.getSuit().equals(Suit.HEARTS)){
				hearts++;
			}
			if(card.getSuit().equals(Suit.SPADES)){
				spades++;
			}
			if(card.getSuit().equals(Suit.DIAMONDS)){
				diamonds++;
			}
		}
		
		assertEquals(13, clubs);
		assertEquals(13, hearts);
		assertEquals(13, spades);
		assertEquals(13, diamonds);
	}
	
	@Test
	public void worthlessRepeatedDeckBySuitTest(){
		
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		List<Value> values = new ArrayList<Value>();
		for(Card card : deck.getCards()){
			if(card.getSuit().equals(Suit.CLUBS)){
				values.add(card.getValue());
			}
		}
		int count = 0;
		for (Value value : values) {
			for(Value value2 : values){
				if(value.getValue() == value2.getValue()){
					count++;
				}
			}
		}
		assertEquals(13, count);
	}
}
