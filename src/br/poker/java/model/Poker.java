package br.poker.java.model;

public enum Poker {

	HIGH_CARD(1),PAIRS(2), TWO_PAIRS(3), THREE_OF_KIND(4), STRAIGHT(5), FLUSH(6), FULL_HOUSE(7), FOUR_OF_KIND(8), STRAIGHT_FLUSH(9);
	
	private Poker(int value){
		this.value = value;
	}
	
	private int value;
	
	public int getValue(){
		return this.value;
	}
}
