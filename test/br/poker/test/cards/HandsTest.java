package br.poker.test.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.poker.java.helper.CardsGenerator;
import br.poker.java.helper.GamesGenerator;
import br.poker.java.model.Deck;
import br.poker.java.model.PokerHand;

public class HandsTest {

	@Test
	public void numberOfCardsOfThePokerHandTest() {
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		
		GamesGenerator game = new GamesGenerator(deck);
		PokerHand hand = game.generateHand();
		
		assertEquals(5, hand.getCards().size());
	}
	
	@Test
	public void deckSizeAfterGeneratingHandTest(){
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		
		GamesGenerator game = new GamesGenerator(deck);
		game.generateHand();
		
		assertEquals(47, deck.getCards().size());
	}

}
