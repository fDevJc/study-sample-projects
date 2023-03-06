package com.jc.dbreplicasample.config.database;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SlavesTest {

	@Test
	void getSlaveName() throws Exception {
		List<String> list = List.of("1번", "2번");
		Slaves slaves = new Slaves(list);

		String slaveName1 = slaves.getSlaveName();
		Assertions.assertThat(slaveName1).isEqualTo("1번");

		String slaveName2 = slaves.getSlaveName();
		Assertions.assertThat(slaveName2).isEqualTo("2번");

		String slaveName3 = slaves.getSlaveName();
		Assertions.assertThat(slaveName3).isEqualTo("1번");
	}
}