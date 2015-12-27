package br.poker.java.model;

import java.util.List;

public class PokerHand {
	
	private List<Card> cards;
	private String hand;

	public PokerHand(List<Card> listCard) {
		this.cards = listCard;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}
	
	public String getHand(){
		return this.hand;
	}

	@Override
	public String toString(){
		
		StringBuilder message = new StringBuilder();
		message.append(hand + ": ");
		
		for (Card card : cards) {
			message.append(card.toString());
			if(!cards.get(cards.size() - 1).equals(card)){
				message.append(" ");
			}
		}
		
		return message.toString();
	}
}
