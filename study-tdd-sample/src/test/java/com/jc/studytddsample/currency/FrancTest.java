package com.jc.studytddsample.currency;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FrancTest {
	@Test
	void testMultiplication() throws Exception {
		Money five = Money.franc(5);

		assertThat(five.times(2)).isEqualTo(Money.franc(10));
		assertThat(five.times(3)).isEqualTo(Money.franc(15));
	}

	@Test
	void testEquals() throws Exception {
		assertThat(Money.franc(5).equals(Money.franc(5))).isTrue();
		assertThat(Money.franc(5).equals(Money.franc(6))).isFalse();
	}
}
