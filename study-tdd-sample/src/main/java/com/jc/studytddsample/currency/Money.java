package com.jc.studytddsample.currency;

import java.util.Objects;

public class Money implements Expression{
	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	String currency() {
		return this.currency;
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

	@Override
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		Money money = (Money)o;
		return amount == money.amount && Objects.equals(currency, money.currency);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, currency);
	}
}
