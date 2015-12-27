package br.poker.java.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.poker.java.model.Card;
import br.poker.java.model.Poker;
import br.poker.java.model.PokerHand;
import br.poker.java.model.Suit;
import br.poker.java.model.Value;

public class ValidatorHand {
	
	private PokerHand pokerHand;
	private Map<Value,Integer> values;
	private Map<Suit,Integer> suits;

	public ValidatorHand(PokerHand hand) {
		this.pokerHand = hand;
		values = new LinkedHashMap<Value,Integer>();
		suits = new HashMap<Suit,Integer>();

		for(Card card : pokerHand.getCards()){
			if(values.get(card.getValue()) == null){
				values.put(card.getValue(),1);
			}else{
				values.put(card.getValue(),values.get(card.getValue())+1);
			}
			
			if(suits.get(card.getSuit()) == null){
				suits.put(card.getSuit(), 1);
			}else{
				suits.put(card.getSuit(), suits.get(card.getSuit())+1);
			}
		}
	}

	public Poker getResult() {

		if(values.size() == 4){
			return Poker.PAIRS;
		}
		if(values.size() == 3){
			for(Value value : values.keySet()){
				if(values.get(value) == 3){
					return Poker.THREE_OF_KIND;
				}
			}
			return Poker.TWO_PAIRS;
		}
		if(values.size() == 5 && suits.size() == 4){
			boolean isStraitgh = isSequence();

			if(isStraitgh){
				return Poker.STRAIGHT;
			}
		}
		if(suits.size() == 1){
			
			boolean isStraitghFlush = isSequence();
			
			if(isStraitghFlush){
				return Poker.STRAIGHT_FLUSH;
			}
			
			return Poker.FLUSH;
		}
		if(values.size() == 2){
			for(Value value : values.keySet()){
				if(values.get(value) == 4){
					return Poker.FOUR_OF_KIND;
				}
			}
			return Poker.FULL_HOUSE;
		}
		return Poker.HIGH_CARD;
	}

	private boolean isSequence() {
		List<Value> listValue = new ArrayList<Value>();
		for(Value value : values.keySet()){
			listValue.add(value);
		}
		Collections.sort(listValue);
		
		int vl = listValue.get(0).getValue();
		int count = 0;
		boolean isSequence = true;

		for (Value value : listValue) {
			if((vl + count) != value.getValue()){
				isSequence = false;
				break;
			}
			count++;
		}
		return isSequence;
	}

	public Map<Value,Integer> getValues(){
		return this.values;
	}
	
	public Map<Suit,Integer> getSuits(){
		return this.suits;
	}
}
