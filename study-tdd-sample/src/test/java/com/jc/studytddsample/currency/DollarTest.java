package com.jc.studytddsample.currency;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DollarTest {
	@Test
	void testMultiplication() throws Exception {
		Dollar five = new Dollar(5);

		Dollar result = five.times(2);
		assertThat(result.amount).isEqualTo(10);

		result = five.times(3);
		assertThat(result.amount).isEqualTo(15);
	}

	@Test
	void testEquals() throws Exception {
		assertThat(new Dollar(5).equals(new Dollar(5))).isTrue();
		assertThat(new Dollar(5).equals(new Dollar(6))).isFalse();
	}
}
