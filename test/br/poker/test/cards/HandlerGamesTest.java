package br.poker.test.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.poker.java.helper.CardsGenerator;
import br.poker.java.helper.GeneratorGame;
import br.poker.java.model.Deck;
import br.poker.java.model.PokerHand;

public class HandlerGamesTest {

	@Test
	public void numberOfCardsOfThePokerHandTest() {
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		
		GeneratorGame game = new GeneratorGame(deck);
		PokerHand hand = game.generateHand();
		
		assertEquals(5, hand.getCards().size());
	}
	
	@Test
	public void deckSizeAfterGeneratingHandTest(){
		
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		
		GeneratorGame game = new GeneratorGame(deck);
		game.generateHand();
		
		assertEquals(47, deck.getCards().size());
		
	}

}
