package com.jc.studytddsample.currency;

public class Dollar {

	int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public void times(int multiplier) {
		amount *= multiplier;

	}
}
