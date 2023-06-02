package com.jc.studytddsample.currency;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class chapter01 {
	@Test
	void testMultiplication() throws Exception {
		Dollar five = new Dollar(5);

		Dollar result = five.times(2);
		Assertions.assertThat(result.amount).isEqualTo(10);

		result = five.times(3);
		Assertions.assertThat(result.amount).isEqualTo(15);
	}
}
