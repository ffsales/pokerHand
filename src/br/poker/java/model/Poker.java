package br.poker.java.model;

public enum Poker {

	HIGH_CARD(1,"High Card"),PAIRS(2,"Pairs"), TWO_PAIRS(3,"Two Pairs"), THREE_OF_KIND(4,"Three of Kind"), STRAIGHT(5,"Straight"), FLUSH(6,"Flush"), 
	FULL_HOUSE(7,"Full House"), FOUR_OF_KIND(8,"Four of Kind"), STRAIGHT_FLUSH(9,"Straight Flush");
	
	private Poker(int value, String desc){
		this.value = value;
		this.desc = desc;
	}
	
	private int value;
	private String desc;
	
	public int getValue(){
		return this.value;
	}
	public String getDesc(){
		return this.desc;
	}
}
