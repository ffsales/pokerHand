package br.poker.java.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.poker.java.helper.ValidatorHand;
import br.poker.java.model.Poker;
import br.poker.java.model.PokerHand;
import br.poker.java.model.Value;
import br.poker.java.model.compareble.ValuesDecreasing;

public class GamePoker {

	public static final String BLACK = "Black";
	public static final String WHITE = "White";
	public static final String TIE = "Tie";

	private PokerHand handWhite;
	private PokerHand handBlack;
	private String handWinner = "";
	
	public GamePoker(PokerHand white, PokerHand black) {
		this.handWhite = white;
		this.handBlack = black;
	}

	public String theWinnerIs() {
		ValidatorHand valWhite = new ValidatorHand(handWhite);
		ValidatorHand valBlack = new ValidatorHand(handBlack);
		Poker white = valWhite.getResult();
		Poker black = valBlack.getResult();
		
		if(white.getValue() == black.getValue()){
			List<Value> listWhite = this.getValuesOrdely(valWhite.getValues(), white);
			List<Value> listBlack = this.getValuesOrdely(valBlack.getValues(), black);
			
			for(int i = 0; i < listWhite.size(); i++){
				if(!listWhite.get(i).getValue().equals(listBlack.get(i).getValue())){
					if(listWhite.get(i).getValue() > listBlack.get(i).getValue()){
						return handWhite.getHand() + " wins - " + getHandWinner(white, listWhite.get(i));
					}else{
						return handBlack.getHand() + " wins - " + getHandWinner(black, listBlack.get(i));
					}			
				}
			}
				
			return GamePoker.TIE;
		}else{
			
			if(white.getValue() > black.getValue()){
				return handWhite.getHand() + " wins - " + getHandWinner(white, null);
			}else{
				return handBlack.getHand() + " wins - " + getHandWinner(black, null);
			}
		}
	}
	
	private List<Value> getValuesOrdely(Map<Value,Integer> mapValue, Poker poker){
		
		int sizeMap = mapValue.keySet().size();
		Value[] values = new Value[sizeMap];
		int count = 1;
		if(poker.equals(Poker.PAIRS)){
			for(Value value : mapValue.keySet()){
				if(mapValue.get(value).equals(2)){
					values[0] = value;
				}else{
					values[count] = value;
					count++;
				}
			}
		}else if(poker.equals(Poker.TWO_PAIRS)){
			for(Value value : mapValue.keySet()){
				if(mapValue.get(value).equals(2)){
					if(values[0] == null & values[1] == null){
						values[0] = value;
					}else if(values[0] != null){
						if(values[0].getValue() < value.getValue()){
							values[1] = values[0];
							values[0] = value;
						}else{
							values[1] = value;
						}
					}else{
						if(values[1].getValue() < value.getValue()){
							values[0] = values[1];
							values[1] = value;
						}
					}
				}else{
					values[sizeMap-1] = value;
				}
			}
		}else if(poker.equals(Poker.THREE_OF_KIND)){
			for(Value value : mapValue.keySet()){
				if(mapValue.get(value).equals(3)){
					values[0] = value;
				}else{
					values[count] = value;
					count++;
				}
			}
		}else if(poker.equals(Poker.STRAIGHT)){
			count = 0;
			for(Value value : mapValue.keySet()){
				values[count] = value;
				count++;
			}
			Arrays.sort(values);
		}else if(poker.equals(Poker.FLUSH) || poker.equals(Poker.STRAIGHT_FLUSH) || poker.equals(Poker.HIGH_CARD)){
			count = 0;
			for(Value value : mapValue.keySet()){
				values[count] = value;
				count++;
			}
			
			List<Value> valuesDecreasing =  Arrays.asList(values);
			Collections.sort(valuesDecreasing, new ValuesDecreasing());
			values = (Value[]) valuesDecreasing.toArray();
		}else if(poker.equals(Poker.FULL_HOUSE)){
			for(Value value : mapValue.keySet()){
				if(mapValue.get(value).equals(3)){
					values[0] = value;
				}else{
					values[1] = value;
				}
			}
		}else if(poker.equals(Poker.FOUR_OF_KIND)){
			for(Value value : mapValue.keySet()){
				if(mapValue.get(value).equals(4)){
					values[0] = value;
				}else{
					values[1] = value;
				}
			}
		}
		
		return Arrays.asList(values);
	}
	
	private String getHandWinner(Poker poker, Value value){
		if(poker.equals(Poker.HIGH_CARD)){
			return poker.getDesc() + ": " + value.getPrint();
		}
		return poker.getDesc();
	}
}