package br.poker.java.model;

import java.util.List;

public class PokerHand {
	
	private List<Card> cards;

	public PokerHand(List<Card> listCard) {
		this.cards = listCard;
	}

	public List<Card> getCards() {
		return this.cards;
	}

}
