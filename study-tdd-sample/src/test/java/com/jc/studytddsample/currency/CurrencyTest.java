package com.jc.studytddsample.currency;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CurrencyTest {
	@Test
	void testCurrency() throws Exception {
		assertThat(Money.dollar(1).currency()).isEqualTo("USD");
		assertThat(Money.franc(1).currency()).isEqualTo("CHF");
	}

	@Test
	void testDifferentClassEquality() throws Exception {
		assertThat(new Money(10, "USD")).isNotEqualTo(new Money(10, "CHF"));
	}

	@Test
	void testSimpleAddition() throws Exception {
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertThat(reduced).isEqualTo(Money.dollar(10));
	}
}
