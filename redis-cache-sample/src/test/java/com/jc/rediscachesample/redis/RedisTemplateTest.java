package com.jc.rediscachesample.redis;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTemplateTest {
	@Autowired
	RedisTemplate redisTemplate;

	@Test
	void redisValueTest() throws Exception {
		String key = "stringKey";
		String value = "hello";
		ValueOperations valueOperations = redisTemplate.opsForValue();

		valueOperations.set(key, value);

		String ret = (String)valueOperations.get(key);
		assertThat(ret).isEqualTo(value);
	}

	@Test
	void redisSetTest() throws Exception {
		String key = "setKey";
		SetOperations setOperations = redisTemplate.opsForSet();

		setOperations.add(key, "h", "e", "l", "l", "o");

		Long ret = setOperations.size(key);
		assertThat(ret).isEqualTo(4);
	}

	@Test
	void redisHashTest() throws Exception {
		String key = "hashKey";
		String value = "value";
		HashOperations hashOperations = redisTemplate.opsForHash();

		hashOperations.put(key, "subKey", value);

		String ret = (String)hashOperations.get(key, "subKey");
		assertThat(ret).isEqualTo(value);

		Map entries = hashOperations.entries(key);
		assertThat(entries.keySet()).contains("subKey");
		assertThat(entries.values()).contains(value);

		Long size = hashOperations.size(key);
		assertThat(size).isEqualTo(1);
	}
}
