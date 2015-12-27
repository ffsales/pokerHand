package br.poker.java.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public enum Value implements Comparator {
	
	DOUNCE(2,"2"),THREE(3,"3"),FOUR(4,"4"),FIVE(5,"5"),SIX(6,"6"),SEVEN(7,"7"),EIGHT(8,"8"),NINE(9,"9"),
	TEN(10,"10"),JACK(11,"J"),QUEEN(12,"Q"),KING(13,"K"),ACE(14,"A");
	
	private Integer value;
	private String print;
	
	public Integer getValue(){
		return this.value;
	}
	
	public String getPrint(){
		return this.print;
	}
	
	private Value(int value,String print){
		this.value = value;
		this.print = print;
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
