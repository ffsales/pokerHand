package br.poker.java.model.compareble;

import java.util.Comparator;

import br.poker.java.model.Value;

public class ValuesDecreasing implements Comparator<Value> {


	@Override
	public int compare(Value obj1, Value obj2) {
		return obj2.getValue().compareTo(obj1.getValue());
	}

}
