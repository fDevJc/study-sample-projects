package com.jc.studytddsample.currency;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DollarTest {
	@Test
	void testMultiplication() throws Exception {
		Money five = Money.dollar(5);
		assertThat(five.times(2)).isEqualTo(Money.dollar(10));
		assertThat(five.times(3)).isEqualTo(Money.dollar(15));
	}

	@Test
	void testEquals() throws Exception {
		assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
		assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
	}
}
