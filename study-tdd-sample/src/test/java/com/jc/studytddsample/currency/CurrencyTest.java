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

	@Test
	void testPlusReturnsSum() throws Exception {
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		assertThat(sum.augend).isEqualTo(five);
		assertThat(sum.addend).isEqualTo(five);
	}

	@Test
	void testReduceSum() throws Exception {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertThat(result).isEqualTo(Money.dollar(7));
	}

	@Test
	void testReduceMoney() throws Exception {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), "USD");
		assertThat(result).isEqualTo(Money.dollar(1));
	}

	@Test
	void testIdentityRate() throws Exception {
		assertThat(new Bank().rate("USD", "USD")).isEqualTo(1);
	}

	@Test
	void testReduceMoneyDifferentCurrency() throws Exception {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertThat(result).isEqualTo(Money.dollar(1));
	}

	@Test
	void testMixedAddition() throws Exception {
		Expression fiveDollar = Money.dollar(5);
		Expression tenFranc = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);

		Money result = bank.reduce(fiveDollar.plus(tenFranc), "USD");

		assertThat(result).isEqualTo(Money.dollar(10));
	}

	@Test
	void testSumPlusMoney() throws Exception {
		Expression fiveDollar = Money.dollar(5);
		Expression tenFranc = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);

		Expression sum = new Sum(fiveDollar, tenFranc).plus(fiveDollar);
		Money result = bank.reduce(sum, "USD");

		assertThat(result).isEqualTo(Money.dollar(15));
	}

	@Test
	void testSumTimes() throws Exception {
		Expression fiveDollar = Money.dollar(5);
		Expression tenFranc = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);

		Expression sum = new Sum(fiveDollar, tenFranc).times(2);
		Money result = bank.reduce(sum, "USD");

		assertThat(result).isEqualTo(Money.dollar(20));
	}
}
