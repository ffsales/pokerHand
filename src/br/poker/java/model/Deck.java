package br.poker.java.model;

import java.util.List;


public class Deck {

	public Deck(List<Card> listCard){
		this.cards = listCard;
	}
	private List<Card> cards;
	
	public List<Card> getCards() {
		
		return this.cards;
	}

}
