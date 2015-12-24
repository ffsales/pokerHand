package br.poker.java.helper;

import java.util.ArrayList;
import java.util.List;

import br.poker.java.model.Card;
import br.poker.java.model.Deck;
import br.poker.java.model.Suit;
import br.poker.java.model.Value;

public class CardsGenerator {
	
	public Deck generateDeck() {
		
		List<Card> listCard = new ArrayList<Card>();
		
		for(Value value : Value.getAllValues()){
			
			listCard.add(new Card(Suit.CLUBS, value));
			listCard.add(new Card(Suit.HEARTS, value));
			listCard.add(new Card(Suit.SPADES, value));
			listCard.add(new Card(Suit.DIAMONDS, value));
		}
		
		return new Deck(listCard);
	}

}
