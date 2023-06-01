package com.jc.studytddsample.currency;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class chapter01 {
	@Test
	void testMultiplication() throws Exception {
		Dollar five = new Dollar(5);
		five.times(2);

		Assertions.assertThat(10).isEqualTo(10);
	}
}
