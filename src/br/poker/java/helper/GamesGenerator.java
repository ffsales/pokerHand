package br.poker.java.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.poker.java.model.Card;
import br.poker.java.model.Deck;
import br.poker.java.model.PokerHand;

public class GamesGenerator {
	
	private Deck deck;

	public GamesGenerator(Deck deck) {
		this.deck = deck;
	}

	public Deck getDeck() {
		return deck;
	}

	public PokerHand generateHand() {
		
		Random random = new Random();
		
		List<Card> cards = new ArrayList<Card>();
		
		
		for(int i = 0; i < 5; i++){

			int allCards = deck.getCards().size();
			int cardNumber = random.nextInt(allCards);
			
			cards.add(deck.getCards().get(cardNumber));
			
			deck.getCards().remove(cardNumber);
			
		}
		
		PokerHand hand = new PokerHand(cards);
		return hand;
	}
}
