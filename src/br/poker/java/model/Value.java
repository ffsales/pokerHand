package br.poker.java.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public enum Value implements Comparator {
	
	DOUNCE(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),
	TEN(10),JACK(11),QUEEN(12),KING(13),ACE(14);
	
	private Integer value;
	
	public Integer getValue(){
		return this.value;
	}
	
	private Value(int value){
		this.value = value;
	}
	
	public static List<Value> getAllValues(){
		List<Value> all = new ArrayList<Value>();
		
		all.add(DOUNCE);
		all.add(THREE);
		all.add(FOUR);
		all.add(FIVE);
		all.add(SIX);
		all.add(SEVEN);
		all.add(EIGHT);
		all.add(NINE);
		all.add(TEN);
		all.add(JACK);
		all.add(QUEEN);
		all.add(KING);
		all.add(ACE);
		
		return all;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		
		return ((Value)obj1).getValue().compareTo(((Value)obj2).getValue());
	}
}
