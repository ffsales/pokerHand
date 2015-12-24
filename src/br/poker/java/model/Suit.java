package br.poker.java.model;

public enum Suit {

	CLUBS("P"), HEARTS("C"), SPADES("E"), DIAMONDS("O");
	
	private String initial;
	
	public String getInitial(){
		return initial;
	}
	
	private Suit(String initial){
		this.initial = initial;
	}
}
