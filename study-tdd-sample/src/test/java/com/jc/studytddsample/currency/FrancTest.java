package com.jc.studytddsample.currency;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FrancTest {
	@Test
	void testMultiplication() throws Exception {
		Franc five = new Franc(5);

		assertThat(five.times(2)).isEqualTo(new Franc(10));
		assertThat(five.times(3)).isEqualTo(new Franc(15));
	}

	@Test
	void testEquals() throws Exception {
		assertThat(new Franc(5).equals(new Franc(5))).isTrue();
		assertThat(new Franc(5).equals(new Franc(6))).isFalse();
	}
}
